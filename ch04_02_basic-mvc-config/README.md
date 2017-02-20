## 4.2 SpringMVC基本配置

### 1. 静态资源的映射
通过`addResourceHandler`可以增加对静态资源的映射。
`addResourceHandler`指对外暴露的地址，`addResourceLocations`指文件放置的位置

### 2. 拦截器的配置
拦截器（Interceptor）可以实现对每一个请求处理前后进行相关业务的处理，类似于`servlet`的`Filter`。
可以让普通类实现`HandlerInterceptor`或继承`HandlerInterceptorAdaptor`类来实现自定义的拦截器。

### 3. @ControllerAdvice
通过`@ControllerAdvice`，可以将对于controller的全局配置放置在同一个位置，注解了`@Controller`的类的方法可以使用`@ExceptionHandler`、`@InitBinder`、`@ModelAttribute`注解到方法上，这对所有注解了`@RequestMapping`的方法有效。

