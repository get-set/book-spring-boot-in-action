## 8.1 Spring Data JPA

1. 定义数据访问层十分简单，只需要定义一个继承`JpaRepository`的接口即可，继承后即可获得`findAll`,`save`等若干常用功能。
其中，定义查询方法即可，无需具体实现，查询方式有如下几种：
  * 最普通的根据属性名查询，如`findByName`,`findByNameAndAddress`；
  * 限制结果数量，如`findFirst10ByName`，`findTop30ByName`；
  * 支持Java JPA的NamedQuery来定义查询方法，通过`@NamedQuery`定义于Entity类上；
  * 支持使用`@Query`定义HQL，可以使用索引或参数来匹配；
  * 支持使用`@Midify`和`@Query`注解组合来实现时间更新查询；
  * 支持排序与分页。

以上示例主要通过内置的JpaRepository来实现。
此外，还支持基于准则查询的方式，即Criteria查询。本示例中通过使用Specification和自定义的JpaRepository来实现更复杂的查询。
> 关于Criteria查询可参考：[详解JPA 2.0动态查询机制:Criteria API](http://developer.51cto.com/art/200911/162722.htm)
2. 关于数据源的配置见`application.properties`。


本例中使用docker启动的mysql，由于官方pull下来的mysql默认使用latin字符集，因此需要给定字符集配置参数：
```
docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=test mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```