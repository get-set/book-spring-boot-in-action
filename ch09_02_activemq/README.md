## 9.2 异步消息——ActiveMQ

异步消息主要目的时为了系统于系统间的通信。其中有两个重要的概念，消息代理(message brocker)和目的地(destination)。消息发送者发出的消息由消息代理接管，消息代理保证消息到达制定的目的地。
异步消息主要有两种目的地，队列(Queue)和主题(Topic)。队列用于点对点的消息通信，主题用于发布/订阅式的消息通信。

1. 使用docker镜像运行一个activeMQ
```
docker run -d -p 61616:61616 -p 8161:8161 --name activemq cloudesire/activemq
```
其中61616是消息代理的端口，8161是管理界面端口，因此可以通过浏览器访问http://localhost:8161打开管理界面。

2. 创建一个Spring Boot程序，依赖中添加`spring-jms`，`active-client`，并在`application.properties`中配置broker-url。

3. 定义JMS发送的消息，需要实现`MessageCreator`接口，并重写其`createMessage`方法。

4. 通过`JmsTemplate`的`send`方法向指定目的地发送消息（也可以从ActiveMQ管理界面发送消息），然后通过监听该目的地接收消息。