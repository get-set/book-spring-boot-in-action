## 3.4 条件判断注解
Spring通过@Condition注解来实现基于条件判断进行Bean创建的方式。具体来说：
1. 作为条件判断的类要实现Condition接口的matches方法；
2. 在配置类中获取Bean的方法出通过注解@Condition指明Condition接口的实现类作为判断依据。
