## 8.4 Spring数据缓存支持

Spring提供了对于缓存的支持，可以通过在配置类上使用`@EnableCaching`即可开启缓存支持。
本例演示了通过注解来实现缓存的几种操作（`DemoServiceImpl`）：
  * `@Cacheable`，在方法执行前先检查缓存中是否有数据，若有，那么直接返回，若无，则方法执行并将返回结果放入缓存；
  * `@CachePut`，无论如何都会将方法返回值放入缓存；
  * `@CacheEvict`，从缓存中删除一条或多条数据；
  * `@Caching`，可以通过该注解组合多个注解策略在一个方法上。
  