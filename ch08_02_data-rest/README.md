## 8.2 Spring Data REST

Spring Data JPA可以直接将Repository自动输出为REST资源。
需要引入`spring-boot-starter-data-rest`依赖，仅此而已，并无其他配置即可。
示例：
* [GET] http://localhost:8080/persons/search/nameStartsWith?name=张
* [GET] http://localhost:8080/persons/?sort=age,desc
* [POST] http://localhost:8080/persons 数据：{"name":"周九","age":29,"address":"天津"}
* [DELETE] http://localhost:8080/persons/2

还可以自定义路径：
* 可以在`application.properties`中定义`spring.data.rest.base-path`来修改根路径；
* 可以在Repository上增加注解`@RepositoryRestResource(path = "xxx")`来修改实体类的路径（默认为实体类名小写+s）。