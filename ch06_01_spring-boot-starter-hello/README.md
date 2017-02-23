## 6.1 自定义的spring boot starter配置

本例是一个自定义的spring-boot-starter。
1. 要依赖`spring-boot-autoconfigure`；
2. 自定义一个properties类，如本例中的`HelloServiceProperties`；
3. 自定义一个AutoConfiguration类，使用`@Configuration`、`@EnableConfigurationProperties`、`@ConditionalOnClass`和`@ConditionalOnProperty`等注解定义；
4. 在resources/META-INF/spring.factories中定义该自动配置类。
