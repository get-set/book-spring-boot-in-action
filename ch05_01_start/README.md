## 5 Spring-boot

本例子包含第5章和第6章6.1的部分。

1. Spring Boot有一个名为`*Application`的入口类，入口类中有`main`方法，用于启动项目。
2. `@SpringBootApplication`注解组合了`@Configuration`、`@EnableAutoConfiguration`和`@ComponentScan`。其中`@EnableAutoConfiguration`使得Spring Boot根据类路径中的jar包依赖，为当前项目进行自动配置，比如：
  * 根据`spring-boot-starter-web`会自动添加Tomcat和Spring MVC的配置；
  * 根据`spring-boot-starter-data-jpa`会自动添加JPA相关配置。
3. 可以修改banner（酷！），在`src/main/resources`下新建`banner.txt`文件即可（http://patorjk.com/software/taag）。
4. Spring Boot的配置可放置于`application.properties`或`application.yaml`内
  * 使用`@Value`可注入配置文件中的值，可以做类型安全的配置，比如`student.*`；
  * 默认Spring Boot使用Logback作为日志框架；
  * 通过`spring.profiles.active=dev`指定使用`application-dev.properties`中的配置，从而实现基于Profile的配置。
