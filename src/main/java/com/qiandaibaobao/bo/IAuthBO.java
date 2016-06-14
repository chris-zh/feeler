package com.qiandaibaobao.bo;

import com.qiandaibaobao.pojo.User;


public interface IAuthBO {
    User fetchUserByNameAndPassword(User user);

    User fetchUserById(User user);

    void registerUser(User user);

    void changePassword(User user);

    User login(User user);

    User logout(User user);
}
