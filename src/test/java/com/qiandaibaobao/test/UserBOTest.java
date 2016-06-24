package com.qiandaibaobao.test;

import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by chris.zhang on 16-6-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
public class UserBOTest {
    @Autowired
    IUserBO bo;
    @Test
    public void user() throws Exception {
        String name = "xh";
        String password = "xh";
        User user = bo.user(name, password);
        System.out.println("user = " + user);
    }

}