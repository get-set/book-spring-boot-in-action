## 4.1 SpringMVC

MVC：Model + View + Controller
三层架构：展现层 + 应用层 + 数据访问层

MVC实际上对应了三层架构里的展现层。
本例为一个简单的SpringMVC项目，基于注解和Java配置的零配置项目。

Spring MVC提供了一个DispatcherServlet来开发Web应用，提供了一个WebApplicationInitializer接口来替换servlet2.5及以下的web.xml配置文件，具体见`WebInitializer`类。

本例中使用了logback记录日志。

在声明普通的Bean时，`@Service`、`@Repository`、`@Controller`、`@Component`都是一样的，因为前三个都包含了`@Component`元注解。而在SpringMVC中声明控制器Bean时，只能使用`@Controller`注解。

`@RequestMapping`用来映射Web请求（访问路径和参数）、处理类和方法。

`@ReponseBody`支持将返回值放在response体内，而不是返回一个页面。通常用于Ajax返回数据。注解可放置于返回值上或方法上。

`@RequestBody`允许request的参数在request体内，而不是直接链接在地址后边。注解放置在参数前。

`@PathVariable`用来接收路径参数，注解放置在参数前。

`@RestController`组合了`@Controller`和`@ReponseBody`，从而主要用于返回数据而不是页面，因此多用于RESTful场景。