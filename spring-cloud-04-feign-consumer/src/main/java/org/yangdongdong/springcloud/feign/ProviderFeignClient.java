package org.yangdongdong.springcloud.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yangdongdong.springcloud.feign.hystrix.ProviderFeignClientHystrixFallback;

@FeignClient(name = "provider", fallback = ProviderFeignClientHystrixFallback.class)
public interface ProviderFeignClient {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello();

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi();

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String getFromPathVariable(@PathVariable("id") String id);

    @RequestMapping(value = "get/", method = RequestMethod.GET)
    public String getFromRequestParam(@RequestParam("id") String id);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("id") String id, @RequestParam("name") String name);

    @RequestMapping(value = "/addFormRequestBody", method = RequestMethod.POST)
    public String addFormRequestBody(@RequestBody Map map);
}
