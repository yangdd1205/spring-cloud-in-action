package org.yangdongdong.springcloud.service.api;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callHelloFailback")
    public String callHello() {
        return restTemplate.getForEntity("http://client/hello", String.class).getBody();
    }

    public String callHelloFailback() {
        System.err.println("callHello 执行降级策略");
        return "callHelloFailback";
    }

    @HystrixCommand(fallbackMethod = "handlerFailback", ignoreExceptions = { FileNotFoundException.class })
    public String handler() {
        throw new RuntimeException("运行时异常。。。。");
    }

    public String handlerFailback(Throwable e) {
        System.err.println("异常信息：" + e.getMessage());
        return "获取异常信息并可以做具体的降级处理";
    }

    @HystrixCommand(commandKey = "hiKey", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000") }, fallbackMethod = "callHiFailback")
    public String callHi(String name) {
        return restTemplate.getForEntity("http://client/hi?name=" + name, String.class).getBody();
    }

    public String callHiFailback(String name) {
        System.err.println("callHi 执行降级策略");
        return "callHiFailback";
    }

    @HystrixCommand(fallbackMethod = "callRequestFailback")
    public String callRequest() {
        return restTemplate.getForEntity("http://client/request", String.class).getBody();
    }

    public String callRequestFailback() {
        System.err.println("callRequest 执行降级策略");
        return "callRequestFailback";
    }

    @HystrixCommand(fallbackMethod = "callCircuitBreakerFailback", commandKey = "circuitBreakerKey", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求总数下限
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"), // 错误百分比下限
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") }) // 休眠时间窗
    public String callCircuitBreaker() {
        System.out.println("callCircuitBreaker 主逻辑");
        return restTemplate.getForEntity("http://client/circuitBreaker", String.class).getBody();
    }

    public String callCircuitBreakerFailback() {
        System.err.println("callCircuitBreaker 执行降级策略");
        return "callCircuitBreakerFailback";
    }

}
