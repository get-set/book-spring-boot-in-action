
Profile支持在不同的环境中使用不同的配置。
从ProfileConfig可以看出，使用不同的Profile时会创建不同的对象。

设置Profile有如下方法：
1. 通过设定Environment的ActiveProfile来设定当前的Context使用的配置环境，本例就是使用这种方式；
2. 通过设定JVM的spring.profiles.active参数来设置配置环境；
3. Web项目设置在Servlet中的context parameter中。