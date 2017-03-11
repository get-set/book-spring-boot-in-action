## 9.1 安全控制Spring Security

安全框架有两个重要的概念：认证（Authentication）和授权（Authorization）。认证即确认用户可以访问当前系统；授权即确定用户所拥有的操作或功能权限。

Spring Security的配置和Spring MVC的配置类似，只需要在一个配置类上注解`@EnableWebSecurity`，并让这个类继承`WebSecurityConofigurerAdapter`即可。然后可以通过重写`configure`方法来配置相关的安全配置。
  * 用户认证是通过重写`protected void configure(AuthenticationManagerBuilder auth)`方法来配置的；
  * 请求授权是通过重写`protected void configure(HttpSecurity http)`方法来配置的，当然也可以用于定制登录行为。

本例通过Spring Data JPA获得用户数据，使用Thymeleaf作为页面模板。

1. 定义用户类`SysUser`和角色类`SysRole`，并通过如下配置开启Hibernate的自动建表（Spring Boot会自动创建用户角色关联表`sys_user_roles`），通过data.sql初始化数据。
```
spring.jpa.hibernate.ddl-auto=update
```
注意的是，用户类继承自`UserDetails`。
2. 数据访问层很简单，只针对`SysUser`定义`SysUserReposity.findByUsername()`。
3. 自定义`UserDetailsService`配置给`WebSecurityConfig`使用。
4. 编写前端页面，页面基于Thymeleaf，通过内置的`sec:authorize="hasRole()`来判断是否具有某种角色。
