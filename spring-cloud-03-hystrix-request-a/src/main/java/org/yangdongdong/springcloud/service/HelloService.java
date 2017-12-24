package org.yangdongdong.springcloud.service;

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
        System.err.println("-------- 执行降级策略 -------");
        return "-------- 执行降级策略 -------";
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
    public String callHi() {
        return restTemplate.getForEntity("http://client/hi", String.class).getBody();
    }

    public String callHiFailback() {
        System.err.println("-------- 执行降级策略 -------");
        return "-------- 执行降级策略 -------";
    }

    @HystrixCommand(fallbackMethod = "callRequestFailback")
    public String callRequest() {
        return restTemplate.getForEntity("http://client/request", String.class).getBody();
    }

    public String callRequestFailback() {
        System.err.println("-------- 执行降级策略 -------");
        return "-------- 执行降级策略 -------";
    }

}
