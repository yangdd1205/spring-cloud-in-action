package org.yangdongdong.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yangdongdong.springcloud.feign.ProviderFeignClient;

@RestController
public class ConsumerController {
    
    @Autowired
    private ProviderFeignClient helloFeignClient;
    
    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String hello() {
        return helloFeignClient.sayHello();
    }
    
    @RequestMapping(value="/hi",method=RequestMethod.GET)
    public String hi() {
        return helloFeignClient.sayHi();
    }
}
