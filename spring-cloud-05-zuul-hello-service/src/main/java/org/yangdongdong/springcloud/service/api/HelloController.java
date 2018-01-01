package org.yangdongdong.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        System.out.println("hello service");
        return "hello!";
    }
   
    @RequestMapping(value="/userInfo",method=RequestMethod.GET)
    public String auth(@RequestHeader("userInfo")String userInfo) {
        return userInfo;
        
    }
    
}
