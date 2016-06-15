package com.qiandaibaobao.dao;

import com.qiandaibaobao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by chris.zhang on 16-6-14.
 */
public interface UserDAO{

    User fetchUserByNameAndPassword(@Param("name")String userName, @Param("password") String password);

    User fetchUserById(@Param("id") int id);

    void addUser(@Param("name") String userName, @Param("password") String password);

    void updateUser(@Param("name") String userName, @Param("password") String password, @Param("id") int id);

    int fetchUserId(@Param("name") String username);

    int countUserName(@Param("name") String userName);
}
