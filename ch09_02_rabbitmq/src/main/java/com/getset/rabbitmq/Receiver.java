package com.getset.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收。
 * Created by kang on 17-3-11.
 */
@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receive(String message) {
        System.out.println("接收消息： " + message);
    }
}
