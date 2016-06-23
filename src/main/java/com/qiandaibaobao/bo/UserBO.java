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
        String salt = dao.userSalt(userName);
        String encryptedPassword = Utils.encrypt(password, salt);
        return dao.fetchUserByNameAndPassword(userName, encryptedPassword);
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
