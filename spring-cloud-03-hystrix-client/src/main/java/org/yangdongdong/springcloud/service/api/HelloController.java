package org.yangdongdong.springcloud.service.api;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("hello hystrix!");
        return "hello hystrix!";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("hi " + name + "!");
        return "hi " + name + "!";
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String request() throws InterruptedException {
        System.out.println("request...");
        return "request";
    }
}
