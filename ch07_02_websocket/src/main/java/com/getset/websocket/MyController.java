package com.getset.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Controller类。
 * Created by Kang on 2017/2/25.
 */
@Controller
public class MyController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;    // 通过SimpMessagingTemplate向浏览器发送消息

    @MessageMapping("/welcome")     // 使用@MessageMapping映射地址，类似于@RequestMapping，浏览器向服务器发送消息时的地址
    @SendTo("/topic/getResponse")   // 当服务器有消息时会对订阅了@SendTo中路径的浏览器发送消息
    public MyResponse say(MyMessage message) throws Exception {
        Thread.sleep(3000);
        return new MyResponse("Welcome, " + message.getName() + "!");
    }

    // 本例中是一段硬编码，主要用于演示get和set之间的消息发送。
    @MessageMapping("/chat")
    public void chat(Principal principal, String msg) {     // SpringMVC中可以直接在参数中获得principle，principle中包含当前用户的信息
        System.out.println("收到消息，来自：" + principal.getName() + "，内容：" + msg);
        if (principal.getName().equals("get")) {
            messagingTemplate.convertAndSendToUser("set", "/queue/notifications", principal.getName() + "-send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("get", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }

}
