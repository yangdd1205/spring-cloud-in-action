package org.yangdongdong.springcloud.service.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yangdongdong.springcloud.feign.ProviderFeignClient;

@RestController
public class ConsumerController {

    @Autowired
    private ProviderFeignClient helloFeignClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return helloFeignClient.sayHello();
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return helloFeignClient.sayHi();
    }

    @RequestMapping(value = "/testPathVariable/{id}", method = RequestMethod.GET)
    public String getData(@PathVariable("id") String id) {
        return helloFeignClient.getFromPathVariable(id);
    }

    @RequestMapping(value = "/testRequestParam", method = RequestMethod.GET)
    public String get(@RequestParam("id") String id) {
        return helloFeignClient.getFromRequestParam(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam("id") String id, @RequestParam("name") String name) {
        return helloFeignClient.add(id, name);
    }

    @RequestMapping(value = "/addFromBody", method = RequestMethod.POST)
    public String addFromBody(@RequestBody Map map) {
        return helloFeignClient.addFormRequestBody(map);
    }

}
