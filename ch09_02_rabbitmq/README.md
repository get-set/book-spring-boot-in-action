## 9.2 异步消息——rabbitMQ


使用docker启动容器：
```
docker pull rabbitmq:management
docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:management
```
可以使用浏览器访问http://localhost:15672进入rabbitMQ的管理界面。
5672是rabbitMQ的连接端口，默认用户名密码是guest，这些也是spring boot的默认配置，因此不用另行添加配置。