package com.qiandaibaobao.dao;

import com.qiandaibaobao.pojo.User;

import java.util.Map;

/**
 * Created by chris.zhang on 16-6-14.
 */
public interface UserDAO{
    public User fetchUserByNameAndPassword(User user);
}
