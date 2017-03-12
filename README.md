《Spring Boot实战》   汪云飞 著

# Spring框架的四个原则
* 使用POJO进行轻量级和最小侵入式开发；
* 使用依赖注入和基于接口编程实现松耦合；
* 通过AOP和默认习惯进行声明式编程；
* 通过AOP和模板减少模式化代码。

# Spring Boot
Spring Boot基于“习惯优于配置”的理念使得项目能够快速搭建起来。具体来说Spring Boot项目：
* 可以以jar包的形式独立运行；
* 可以内嵌tomcat，jetty等容器；
* 提供了一系列的starter pom来简化Maven的依赖加载；
* 会根据在类路径中的jar包或类，为其自动配置Bean；
* 提供基于http/ssh/telnet对运行时项目进行监控；
* 无代码生成和xml配置，而是通过条件注解实现；
* 与云计算天然集成。

# 示例说明
每个chxx_xx_xxxx是一个独立的例子，因此建议使用IDEA导入为maven项目，导入时以recursive的方式，这样所有的例子均导入为module。

>示例代码是边看书边手敲的，chxx的章节号是对应的，但是第二编号跟小节号并不对应，有些可能书上两节的例子合并到一个例子上。

* 对于ch01-ch04的例子，是构建为war包的，使用tomcat等容器运行即可；
* 对于ch05-ch09的例子，是SpringBoot的，构建为jar包可直接运行，开发时直接跑`XxxXxxAplication`的main方法即可；
* 其中ch08之后的例子中涉及数据访问，为了方便操作使用了docker来运行数据库或AMQP；

>运行前，请先安装docker，所用到的镜像有
>```
>docker pull mysql      # 书中用的是Oracle XE，不过对于示例来说都差不多
>docker pull cloudesire/activemq
>docker pull rabbitmq:management
>docker pull redis
>```
>使用时启动容器：
>```
># MySQL预先配置root密码123456，创建数据库test，使用UTF-8编码
>docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=test mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
>docker run -d --name activemq -p 61616:61616 -p 8161:8161 cloudesire/activemq
>docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
>docker run -d --name redis -p 6379:6379 redis
>```

* 对于ch12的例子，是一个简单的微服务的例子，具体运行方法[在这](ch12_01_microservice)。


# 示例索引
* 1 Spring基础
  *  [1.1 依赖注入](ch01_01_di)
  *  [1.2 Java配置方式](ch01_02_java-config)
  *  [1.3 AOP](ch01_03_aop)
* 2 Spring常用配置
  *  [2.1 Bean的Scope](ch02_01_scope)
  *  [2.2 Spring EL和资源调用](ch02_02_el)
  *  [2.3 Spring初始化与销毁](ch02_03_prepost)
  *  [2.4 Profile](ch02_04_prepost)
  *  [2.5 事件(Application Event)](ch02_05_event)
* 3 Spring高级话题
  *  [3.1 Spring Aware](ch03_01_aware)
  *  [3.2 任务多线程](ch03_02_taskexecutor)
  *  [3.3 定时任务](ch03_03_taskscheduler)
  *  [3.4 条件注解](ch03_04_conditional)
  *  [3.5 组合注解](ch03_05_annotation)
  *  [3.7 测试](ch03_07_test)
* 4 Spring MVC基础
  *  [4.1 Spring MVC](ch04_01_springmvc4)
  *  [4.2 Spring MVC 常用配置](ch04_02_basic-mvc-config)
  *  [4.3 文件上传](ch04_03_fileupload)
  *  [4.4 自定义HttpMessageConverter](ch04_04_http-msg-converter)
  *  [4.5 服务器端推送](ch04_05_server-push)
  *  [4.6 Spring MVC测试](ch04_06_test)
* 5 初识Spring Boot
  *  [5.1 Spring Boot项目搭建](ch05_01_start)
* 6 Spring Boot核心
  *  [6.1 基本配置](ch06_01_spring-boot-hello)
  *  [6.2 Spring Boot运行原理](ch06_01_spring-boot-starter-hello)
* 7 Spring Boot Web 开发
  *  [7.1 基本配置与集成Thymeleaf](ch07_01_thymeleaf)
  *  [7.2 WebSocket支持](ch07_02_websocket)
* 8 Spring Boot 数据访问
  *  [8.1 Spring Data JPA](ch08_01_jpa)
  *  [8.2 Spring Data Rest](ch08_02_data-rest)
  *  [8.3 声明式事务](ch08_03_transaction)
  *  [8.4 数据缓存cache](ch08_04_cache)
* 9 Spring Boot 企业级开发
  *  [9.1 集成Spring Security](ch09_01_security)
  *  [9.2 异步消息-activeMQ](ch09_02_activemq)
  *  [9.2 异步消息-rabbitMQ](ch09_02_rabbitmq)
  *  [9.3 Spring Boot测试](ch09_03_springboot_test)
* 10 Spring Boot开发部署与测试（略，用上边的示例玩儿即可）
  
* 11 应用监控（略，用上边的示例玩儿即可）
  
* 12 分布式系统开发
  *  [12.1 Spring Cloud 微服务 Docker部署](ch12_01_microservice)