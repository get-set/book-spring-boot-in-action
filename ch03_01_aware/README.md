## 3.1 Spring Aware
依赖注入最大的特点是Bean对Spring容器的存在是不知道的，所以耦合度很低。
但是在实际项目中，不可避免的要用到Spring容器本身的功能资源，这时候Bean需要意识到Spring容器的存在，获取到容器的信息，从而调用pring的资源，不过这时候也就会跟Spring耦合了。
Spring提供了几个Aware接口：
 
| 接口 | 说明 |
| --- | --- |
| BeanNameAware | 获取到容器中Bean的名称 |
| BeanFactoryAware | 获得当前的bean factory，从而可以调用Bean的服务 |
| ApplicationContextAware | 获得当前的application context |
| MessageSourceAware | 获得message source，这样可以获得文本信息 |
| ApplicationEventPublisherAware | 启用时间发布器，可以发布事件 |
| ReourceLoaderAware | 获得资源加载器，从而可以获得外部资源文件 |
 
Bean集成ApplicationContextAware可以获得Spring容器的所有Aware服务。
 
 
 