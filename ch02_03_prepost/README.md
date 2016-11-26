## Bean的初始化和销毁
Spring能够对Bean的生命周期的操作进行支持，比如在构建后和销毁前进行一些操作。
本例中有两种形式的管理方式：
1. Java配置方式：在PrePostConfig中，使用@Bean的参数initMethod和destroyMethod进行定义；
2. JSR250注解方式：在Bean中使用@PostConstruct和@PreDestroy进行定义，Spring可以解析。