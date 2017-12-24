package org.yangdongdong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine // 启用收集断路器集群服务功能
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
    // 要监控的 turbine 地址 [监控 request 服务]: http://localhost:6002/turbine.stream
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
