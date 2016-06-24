package com.qiandaibaobao.bo;

import com.qiandaibaobao.pojo.User;


public interface IUserBO {
    /**
     * 查询User
     * @param userName
     * @param password
     * @return
     */
    User user(String userName, String password);
    User user(int id);

    void login(User user);

    void logout(User user);

    boolean register(String userName, String password);
    void updateUser(String userName, String password);
}
