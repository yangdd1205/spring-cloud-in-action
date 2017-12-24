package org.yangdongdong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker // 开启断路器功能
@EnableDiscoveryClient
@SpringBootApplication
public class RequestApplication {

    @Bean
    @LoadBalanced // 自动负载均衡：他的机制是（通过）Application Name去寻找服务发现，然后去做负载均衡策略的
    public RestTemplate restTemplate() {
        return new RestTemplate(httpRequestFactory());
    }

    @Bean
    @ConfigurationProperties(prefix = "custom.http")
    public HttpComponentsClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }
   
    
    public static void main(String[] args) {
        SpringApplication.run(RequestApplication.class, args);
    }
}
