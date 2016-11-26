## 3.7 测试
Spring 通过 Spring testContext Framework 对集成测试提供支持，它不依赖与特定的测试程序，支持JUnit和testNG。
Spring 提供了一个`SpringJUnit4ClassRunner`类，提供了Spring testContext Framework的功能。
* 通过`@ContextConfiguration`来配置Application Context；
* 通过`@ActiveProfiles`来声明活动的profile。