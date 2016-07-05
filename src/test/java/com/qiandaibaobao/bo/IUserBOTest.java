package com.qiandaibaobao.bo;

import com.qiandaibaobao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by chris.zhang on 16-6-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml",
"file:src/main/webapp/WEB-INF/applicationContext-redis.xml"})
public class IUserBOTest {
    @Autowired
    IUserBO bo;
    @Test
    public void saveAvatar() throws Exception {

//        String path = "C:\\ideaprojects\\feeler\\target\\feeler";
//        bo.saveAvatar(10, avatar, path);
        System.out.println("bo = " + bo);
    }

//    @Test
//    public void cacheUser() throws Exception{
//        User user = bo.user(10);
//        bo.cacheUser(user);
//        System.out.println("hahaha");
//
//        User user2 = bo.fetchCachedUser(10);
//        System.out.println("user2 = " + user2);
//
//        User user3 = bo.fetchCachedUser(10);
//        System.out.println("user3 = " + user3);
//    }

}