## 8.3 声明式事务

Spring支持声明式事务，即使用注解（`@Transactional`）来选择需要使用事务的方法。
本例演示了使用`@Transactional`注解的时候定义异常是否导致数据回滚的情况。

具体见`DemoServiceImpl`类中的两个实现方法。