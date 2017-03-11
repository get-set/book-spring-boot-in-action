## 12 分布式系统开发

### 总述
Spring Cloud为我们解决分布式开发常用到的问题给出了完整的解决方案。它基于Spring Boot，提供了配置管理/服务发现/断路器/代理服务等在分布式开发中常见问题的解决方案。

**配置服务**
Spring cloud提供了Config Server，它有在分布式系统开发中配置外部组件的功能，从而可以集中存储所有应用的配置文件。
Spring Cloud提供了注解`@EnableConfigServer`来启用配置服务。
如本例中的 config 服务，为person和some两个服务提供外部配置，`resources/config/`下保存了person和some两个模块的配置文件，而且根据部署环境进行区分，格式为`app[-profile].yml`。

**服务发现**
Spring Cloud 通过 Netflix OSS 的 Eureka 来实现服务发现，服务发现的主要目的时为了让每个服务之前可以互相通信。Eureka Server 为微服务注册中心。
Spring Cloud 使用注解的方式配置 Eureka 服务端（`@EnableEurekaServer`）和客户端（`@EnableEurekaClient`）。
如本例中的 discovery 服务。

**路由网关**
路由网关的主要目的是为了让所有的微服务对外只有一个接口，从而只需要访问一个网关地址，即可由网关将请求代理到不同的服务中。
Spring Cloud 是通过 Zuul 来实现路由网关功能的，它支持自动路由映射到在 Eureka Server 上注册的服务。 Spring Cloud 提供了注解 `@EnableZuulProxy` 来启用路由代理。
本例中 UI 服务作为应用网关，提供外部访问的统一入口。 


**负载均衡**
Spring Cloud 提供了 Ribbon 和 Feign 作为客户端的负载均衡。在Spring Cloud下，
  1. 使用 Ribbon 直接注入一个 `RestTemplate` 对象即可，此 `RestTemplate` 已做好负载均衡的配置；
  2. 使用 Feign 只需定义个注解，有 `@FeignClient` 注解的接口， 然后使用 `@RequestMapping` 注解在方法上映射远程的REST服务，此方法也是做好负载均衡配置的。

使用 Feign 消费 person 服务，Ribbon 消费 some 服务，且都提供断路器功能。断路器功能由 monitor 服务提供。

### 开发运行
首先启动服务发现和配置的功能，因此依次启动 DiscoveryApplication 和 ConfigApplication，然后再把其他服务起来即可，其他服务顺序随意。
然后访问`http://localhost:8761`，访问 Eureka Server 的界面，可以看到“Instances currently registered with Eureka”下各服务陆续被发现。
在浏览器中访问`http://localhost:8081/`，会自动跳转到“http://localhost:8081/#/person”，即路由到了 person 服务；访问“http://localhost:8081/#/some”，即路由到了 some 服务。
停止 person 和 some 服务，再次访问上一步的地址，可以观察到断路器已经起作用。访问“http://localhost:8989/hystrix.stream”即为监控界面，输入“http://localhost:8081/hystrix.stream”然后点击“Monitor Stream”按钮查看监控信息。

### 代码分析
**discovery**
1. 添加依赖`spring-cloud-starter`和`spring-cloud-starter-eureka-server`；
2. 使用`@EnableEurekaServer`开启服务发现的支持，其他被发现的服务要使用`@EnableEurekaClient`注解；
3. 配置`application.yml`，代码中有解释。

**config**
1. 添加依赖`spring-cloud-starter`，`spring-cloud-config-server`和`spring-cloud-starter-eureka`；
2. 使用`@EnableConfigServer`开启配置服务的支持；
3. Spring Cloud 允许应用使用`bootstrap.yml`（或`bootstrap.propertiey`）来从外部资源加载配置。

**person/some**
1. 添加依赖`spring-boot-starter-data-jpa`用于数据访问（开发环境使用hsqldb，docker生产环境使用PostgreSQL），当然还有作为eureka client和config client的依赖；
2. 功能本身就是实现了一个RESTfuel的接口；
3. 配置来自ConfigServer，在`bootstrap.yml`中配置ConfigServer的服务名，获取到的config分为开发和生产两种环境。

**ui**
1. 添加ribbon，feign，zuul以及CircuitBreaker的相关依赖；
2. 使用`@EnableFeignClients`开启Feign客户端支持，使用`@EnableCircuitBreaker`开启CircuitBreaker支持，使用`@EnableZuulProxy`开启网关代理的支持；
3. 使用feign调用person服务（`PersonService`上使用`@FeignClient`），定义断路器（使用`@HystrixCommand(fallbackMethod = ...)；
4. 通过注入一个`RestTemplate`即可使用Ribbon调用some服务，病开启断路器；
5. 配置`bootstrap.yml`。

**monitor**
1. 添加依赖`spring-cloud-starter-hystrix-dashboard`和`spring-cloud-starter-turbine`；
2. 使用`@EnableEurekaClient`，`@EnableHystrixDashboard`和`@EnableTurbine`来开启相关支持；
3. 配置`bootstrap.yml`。

### 生产部署到docker
1. 在各个应用源码中有个`docker`目录，其中有`runboot.sh`和`Dockerfile`；
2. 使用`docker-maven-plugin`来编译Docker镜像到服务器（默认编译到localhost），编译命令`mvn clean package docker:build -DskipTests`；
3. 使用docker compose来运行整个应用，`docker-compose up -d`。
