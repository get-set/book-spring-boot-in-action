## 7.2 WebSocket

WebSocket为浏览器和服务器端提供了双工异步通信的功能，不仅浏览器可以向服务器发送消息，服务器也可以向浏览器发送消息。
WebSocket通过一个socket来实现双工异步通信能力。通常使用STOMP协议（是一个更高级别的协议）来开发，以便简化。STOMP使用基于帧（frame）的格式来定义消息。

### 1. 广播式
服务器有消息时， 会将消息发送给所有连接了当前endpoint的浏览器。
1. 配置WebSocket，需要在配置类（如WebSocketConfig）中使用`@EnableWebSocketMessageBroker`来开启WebSocket支持，并通过继承`@EnableWebSocketMessageBroker`类，重写其方法来配置WebSocket。
2. 配置消息处理用的Controller（如`MyController`），类似于普通http Request的处理，这里使用`@MessageMapping`，另外需要使用`@SendTo`指定反馈发送到的订阅地址。
3. 在页面上使用sockjs和stomp的JavaScript方法同服务器基于socket建立WebSocket连接，通过发送和订阅实现消息交互。