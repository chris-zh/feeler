package com.qiandaibaobao.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
public class ProducerServiceImplTest {
    @Autowired
    private ProducerService producerService;

    @Autowired
    private Destination queueDestination;

    @Test
    public void sendMessage() throws Exception {
        for (int i=0; i<2; i++) {
            producerService.sendMessage(queueDestination, "你中奖了！" + (i+1));
        }
    }

}