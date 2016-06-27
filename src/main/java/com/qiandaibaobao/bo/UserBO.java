package com.qiandaibaobao.bo;

import com.qiandaibaobao.dao.UserDAO;
import com.qiandaibaobao.page.FeelerConfig;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.ImgCompress;
import com.qiandaibaobao.util.Utils;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
@Component
public class UserBO implements IUserBO {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDAO dao;

    /**
     * 查询User
     * @param userName 用户名
     * @param password 加密前的密码
     * @return
     */
    public User user(String userName, String password) {
        String salt = dao.userSalt(userName);
        String encryptedPassword = Utils.encrypt(password, salt);
        return dao.user(userName, encryptedPassword);
    }

    public User user(int id) {
        return dao.fetchUserById(id);
    }

    public void updateUser(String userName, String password) {
        int id = dao.fetchUserId(userName);
        String newSalt = Utils.newSalt();
        String newPassword = Utils.encrypt(password, newSalt);
        dao.updateUser(userName, newPassword, newSalt, id);
    }

    @Override
    public boolean saveAvatar(int id, String avatar, String projectPath) {
        //todo 1.获取avatar文件名， 2. 存avatar到数据库 3. 存avatar图片到文件系统
        //todo 1. 解码  2.存文件系统 3. 存数据库

        //todo 1. 获取字节数组 2.生成avatar文件名 2.5根据avatar文件名，生成临时文件
        //todo 3.获得小图片源路径和目标路径 4.获得大图片源路径和目标路径
        //todo 4.生成小图片和大图片
        //todo 5.保存avatar文件名
        FeelerConfig config = new FeelerConfig();
        byte[] imageBytes = Utils.decode(avatar);
        User user = this.user(id);
        String avatarName = String.format("%s-%s%s", id, user.getName(), ".jpg");
        File tmpFile = new File(avatarName);
        try {
            FileOutputStream outputStream = new FileOutputStream(tmpFile);
            FileChannel channel = outputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(imageBytes.length);
            try {
                buffer.put(imageBytes);
                buffer.rewind();
                channel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String tmpFileAbsolutePath = tmpFile.getAbsolutePath();
        String smallImageAbsolutePath = String.format("%s//%s%s", projectPath, config.getSmallPrefix(), avatarName);
        String bigImageAbsolutePath = String.format("%s//%s%s", projectPath, config.getBigPrefix(), avatarName);

        try {
            ImgCompress.compress(tmpFileAbsolutePath, smallImageAbsolutePath, config.getSmallAvatar());
            ImgCompress.compress(tmpFileAbsolutePath, bigImageAbsolutePath, config.getBigAvatar());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tmpFile.delete();
//        String savePath = String.format("%s//%s",projectPath,config.getUserImageRelativeBasePath());
//        byte[] bytes = Utils.decode(avatar);
//        User user = this.user(id);
//        String avatarName = String.format("%s-%s%s", String.valueOf(id), user.getName(),".jpg");
//        String fullPath = String.format("%s%s",savePath,avatarName);
        dao.saveAvatar(id, avatarName);
        return true;
    }

    public void login(User user) {

    }

    public void logout(User user) {

    }

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
