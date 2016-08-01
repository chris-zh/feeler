package com.qiandaibaobao.bo;

import com.qiandaibaobao.dao.UserDAO;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.ImgCompress;
import com.qiandaibaobao.util.Utils;
import io.protostuff.*;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
@Component
public class UserBO implements IUserBO {
    Logger logger = Logger.getLogger(this.getClass());
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDAO dao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations<byte[], byte[]> valueOperations;

    private RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);

    /**
     * 通过用户名和密码查询用户
     * 从数据库中读取，并同步到缓存中
     * @param userName 用户名
     * @param password 加密前的密码
     * @return
     */
    public User user(String userName, String password) {
        String salt = dao.userSalt(userName);
        String encryptedPassword = Utils.encrypt(password, salt);
        User user = dao.user(userName, encryptedPassword);
        if (user != null) {
            this.cacheUser(user);
        }
        return user;
    }

    /**
     * 通过ID查询用户
     * 优先从缓存中读取
     * @param id
     * @return
     */
    public User user(int id) {
        User user = this.fetchCachedUser(id);
        if (user == null) {
            user = dao.fetchUserById(id);
        }
        return user;
    }

    /**
     * 修改密码
     * @param userName
     * @param password
     */
    public void changePassword(String userName, String password) {
        int id = dao.fetchUserId(userName);
        String newSalt = Utils.newSalt();
        String newPassword = Utils.encrypt(password, newSalt);
        dao.changePassword(userName, newPassword, newSalt, id);
    }

//    /**
//     * 辣鸡代码简直不忍直视
//     * @param id
//     * @param avatar
//     * @param projectPath
//     * @return
//     */
//    @Override
//    public boolean saveAvatar(int id, String avatar, String projectPath) {
//        /*web头像上传问题
//
//        需求：
//        用户上传头像，可点击查看小头像和大头像
//
//        思路：
//        用户上传头像之后，通过压缩算法生成小头像和大头像。
//
//        访问头像：web项目的绝对路径访问
//        http://localhost:8080/resources/{userId}/avatar_0.jpg (小头像)
//        http://localhost:8080/resources/{userId}/avatar_1.jpg (大头像)
//
//
//        存储路径：
//        webapp/resources/userImage/{userId}/avatar_0.jpg
//        webapp/resources/userImage/{userId}/avatar_1.jpg
//
//        数据库：
//        avatarBig, avatarSmall
//
//        解决方案：
//        存储时：动态获得项目的根路径，从而得到resources的物理路径
//        读取时：通过request.getContext()得到项目根路径，从而得到resources的路径
//        */
//        String repositoryPath = projectPath+File.separator+"resources"+File.separator+
//                "userImage" + File.separator + String.valueOf(id) + File.separator;
//        File repository = new File(repositoryPath);
//        if (!repository.exists()) {
//            boolean success = repository.mkdir();
//            if(!success){
//                logger.error(String.format("创建路径失败：%s", repositoryPath));
//            }
//        }
//        User user = this.user(id);
//        String avatarName = String.format("%s_%s", id, user.getName());
//        File tmpFile = new File(avatarName);
//
//        byte[] imageBytes = Utils.decode(avatar);//图片字节数组
//        String tmpFilePath = repositoryPath+tmpFile.getName();
//        String[] avatars = Utils.avatars(avatarName);//两个avatar文件名
//        String avatarBig = avatars[0];
//        String avatarSmall = avatars[1];
//        String descBigAvatarPath = repositoryPath+avatarBig;
//        String descSmallAvatarPath = repositoryPath+avatarSmall;
//        //生成临时文件
//        try {
//            Utils.writeBytes(imageBytes, tmpFilePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            ImgCompress.compress(tmpFilePath, descBigAvatarPath, new int[]{250,250});
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            ImgCompress.compress(tmpFilePath, descSmallAvatarPath, new int[]{35,35});
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        dao.saveAvatar(id, avatarBig, avatarSmall);
//        return true;
//    }

    /**
     * 缓存用户
     * @param user
     */
    public void cacheUser(User user) {
        String key = "user" + user.getId();
        byte[] bytes = ProtobufIOUtil.toByteArray(user, schema,
                LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        valueOperations.set(key.getBytes(), bytes);
    }

    /**
     * 从缓存读取用户
     * @param id
     * @return
     */
    public User fetchCachedUser(int id) {
        String key = "user" + id;
        byte[] bytes = valueOperations.get(key.getBytes());
        if (bytes != null) {
            User user = schema.newMessage();
            ProtobufIOUtil.mergeFrom(bytes, user, schema);
            return user;
        }
        return null;
    }

    /**
     * 注册新用户
     * @param userName
     * @param password
     * @return
     */
    public boolean register(String userName, String password) {
        int countUserName = dao.countUserName(userName);
        String newSalt = Utils.newSalt();
        if(countUserName==0){
            dao.addUser(userName, Utils.encrypt(password, newSalt), newSalt);
            return true;
        }else{
            return false;
        }

    }
}
