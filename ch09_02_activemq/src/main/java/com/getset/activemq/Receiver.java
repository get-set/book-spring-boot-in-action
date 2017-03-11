package com.getset.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听。
 * Created by kang on 17-3-11.
 */
@Component
public class Receiver {

    @JmsListener(destination = "my-destination")
    public void receiverMessage(String message) {
        System.out.println("接受消息： " + message);
    }
}
