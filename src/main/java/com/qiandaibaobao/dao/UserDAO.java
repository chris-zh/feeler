package com.qiandaibaobao.dao;

import com.qiandaibaobao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by chris.zhang on 16-6-14.
 */
public interface UserDAO{


    User fetchUserById(@Param("id") int id);

    void addUser(@Param("name") String userName, @Param("password") String password, @Param("salt") String salt);

    void changePassword(@Param("name") String userName, @Param("password") String password, @Param("salt")String salt, @Param("id") int id);

    int fetchUserId(@Param("name") String username);

    int countUserName(@Param("name") String userName);

    String userSalt(@Param("name") String userName);

    User user(@Param("name") String userName, @Param("password") String password);

//    void saveAvatar(@Param("id") int id, @Param("avatarBig") String avatarBig, @Param("avatarSmall") String avatarSmall);
}
