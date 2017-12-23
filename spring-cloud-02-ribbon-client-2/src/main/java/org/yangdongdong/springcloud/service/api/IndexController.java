package org.yangdongdong.springcloud.service.api;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(String name) {
        System.out.println("client 2");
        return "hello " + name;
    }

    @RequestMapping(value = "/retry", method = RequestMethod.GET)
    public String retry() {
        System.err.println("client 2 call.......");
        // try {
        // // 模拟超时
        // TimeUnit.SECONDS.sleep(6);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return "client 2";
    }

}
