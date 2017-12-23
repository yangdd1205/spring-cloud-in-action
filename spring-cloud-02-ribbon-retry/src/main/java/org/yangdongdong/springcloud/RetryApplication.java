package org.yangdongdong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@EnableRetry // 启用 Retry 框架的重试机制
@EnableDiscoveryClient
@SpringBootApplication
public class RetryApplication {

    @Bean
    @LoadBalanced // 自动负载均衡：他的机制是（通过）Application Name去寻找服务发现，然后去做负载均衡策略的
    public RestTemplate restTemplate() {
        // HttpComponentsClientHttpRequestFactory httpRequestFactory = new
        // HttpComponentsClientHttpRequestFactory();
        // httpRequestFactory.setConnectionRequestTimeout(1000);
        // httpRequestFactory.setConnectTimeout(1000);
        // httpRequestFactory.setReadTimeout(3000);
        return new RestTemplate(httpRequestFactory());
    }

    @Bean
    @ConfigurationProperties(prefix = "custom.http")
    public HttpComponentsClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }

    public static void main(String[] args) {
        SpringApplication.run(RetryApplication.class, args);
    }
}
