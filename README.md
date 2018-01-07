# Spring Cloud 实战

介绍了 Spring Cloud 常用的组件，外加 Spirng Cloud 实战小项目。欢迎 Star 和 Fork。

## 版本

使用 Edgware 版本。注意 Edgware 版本中，重命名了很多 starter 的 Artifact ID。虽然在 Edgware 版中，原 Artifact ID 依然可用，使用已过时的 starter 将记录一个警告，并在其中使用新启动程序的名称，新旧名的对照表可以去 [Spring Cloud Edgware Release Notes](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Edgware-Release-Notes)。

## 准备

* JDK 8
* Maven 3
* IDE：STS or Eclipse （当然 IDEA 也行，我只是觉得它的 Boot Dashboard 不是太好用）

## 目录

1. [Spring Cloud 简介](http://yangdongdong.org/2017/12/17/introduction-to-spring-cloud)
2. [Spring Cloud Eureka：服务注册与发现](http://yangdongdong.org/2017/12/20/spring-cloud-eureka)
   * Eureka Server
   * Eureka Client
   * Eureka 的高可用
   * 服务注册与发现机制
3. [Spring Cloud Ribbon：负载均衡](http://yangdongdong.org/2017/12/23/spring-cloud-ribbon/)
   * RestTemplate
   * Spring Retry 失败重试
4. [Spring Cloud Hystrix：断路器](http://yangdongdong.org/2017/12/30/spring-cloud-hystrix/)
   * Hystrix
   * Dashboard
   * Turbine
5. [Spring Cloud Feign：声明式 REST 客户端](http://yangdongdong.org/2017/12/31/spring-cloud-feign)
   * 负载均衡、断路器、请求重试以及踩坑
6. [Spring Cloud Zuul：网关](http://yangdongdong.org/2018/01/07/spring-cloud-zuul/)
    * Filter
    * File Upload
7. - [ ] [Spring Cloud Config：配置中心](#) (预计完成时间1月14号)
8. - [ ] [Spring Cloud Bus：消息总线](#)
8. - [ ] [Spring Cloud Stream：消息队列](#)
9. - [ ] [Spring Cloud 实战：Token 网关登录认证](#)

## 我的博客

主页：http://yangdongdong.org

Spring Cloud 系列：http://yangdongdong.org/categories/Spring-Cloud

## 联系我
通过 Issues 或者邮件联系我。

Email：yangdd1205@126.com

## License

This project is licensed under the MIT License - see the [LiCENSE](https://github.com/yangdd1205/spring-cloud-master/blob/master/LICENSE) file for details.
