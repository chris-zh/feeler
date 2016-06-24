package com.qiandaibaobao.test;

import com.qiandaibaobao.dao.PostDAO;
import com.qiandaibaobao.pojo.Comment;
import com.qiandaibaobao.pojo.Post;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chris.zhang on 16-6-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
public class PostDAOTest {
    protected Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    PostDAO dao;
    @Test
    public void posts() throws Exception {
        System.out.println("dao = " + dao);
        List<Post> list =  dao.posts(10);
//        List<Comment> cList = dao.comments(1);
        System.out.println("list = " + list);
//        System.out.println("c = " + cList);
    }

}