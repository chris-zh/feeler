package com.qiandaibaobao.bo;

import com.qiandaibaobao.dao.UserDAO;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
@Component
public class UserBO implements IUserBO {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDAO dao;
    public User user(String userName, String password) {
        return dao.fetchUserByNameAndPassword(userName, password);
    }

    public User user(int id) {
        return dao.fetchUserById(id);
    }

    public void login(User user) {

    }

    public void logout(User user) {

    }

    public boolean register(User user) {
        int countUserName = dao.countUserName(user.getName());
        if(countUserName==0){
            dao.addUser(user.getName(), user.getPassword(), user.getSalt());
            return true;
        }else{
            return false;
        }

    }

    /**
     * 修改密码
     * 支持校验旧密码和不校验旧密码两种情况
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public boolean changePassword(String userName, String oldPassword, String newPassword) {
        int userId = -1;
        if(oldPassword!=null){
            User oldUser = dao.fetchUserByNameAndPassword(userName, oldPassword);
            userId = oldUser.getId();
        }else{
            userId = dao.fetchUserId(userName);
        }
        if(userId == -1){
            return false;
        }else{
            dao.updateUser(userName, newPassword, Utils.currentSalt(), userId);
            return true;
        }
    }

}
