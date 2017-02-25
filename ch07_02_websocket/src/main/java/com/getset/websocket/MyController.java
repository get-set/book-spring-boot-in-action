package com.getset.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Controller类。
 * Created by Kang on 2017/2/25.
 */
@Controller
public class MyController {

    @MessageMapping("/welcome")     // 使用@MessageMapping映射地址，类似于@RequestMapping，浏览器向服务器发送消息时的地址
    @SendTo("/topic/getResponse")   // 当服务器有消息时会对订阅了@SendTo中路径的浏览器发送消息
    public MyResponse say(MyMessage message) throws Exception {
        Thread.sleep(3000);
        return new MyResponse("Welcome, " + message.getName() + "!");
    }

}
