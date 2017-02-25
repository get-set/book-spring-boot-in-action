package com.getset.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * WebSocket配置类。
 * Created by Kang on 2017/2/25.
 */
@Configuration
@EnableWebSocketMessageBroker   // 开启使用STOMP协议来传输基于代理的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    // 1. 注册endpoint并映射指定的URL，指定使用SockJS协议
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointkk").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    // 2. 配置消息代理。
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.enableSimpleBroker("/queue");
    }
}
