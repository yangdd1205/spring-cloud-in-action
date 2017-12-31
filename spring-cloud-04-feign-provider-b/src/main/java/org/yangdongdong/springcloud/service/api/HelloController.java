package org.yangdongdong.springcloud.service.api;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        System.out.println("provider-b hello feign!");
        return "hello feign!";
    }
    
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("provider-b hi feign!");
        return "hi feign!";
    }
}
