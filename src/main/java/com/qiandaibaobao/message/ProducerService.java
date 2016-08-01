package com.qiandaibaobao.message;

import javax.jms.Destination;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public interface ProducerService {
    public void sendMessage(Destination destination, final String message);
}
