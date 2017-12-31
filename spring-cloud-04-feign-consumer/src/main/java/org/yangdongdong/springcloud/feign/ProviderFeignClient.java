package org.yangdongdong.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yangdongdong.springcloud.feign.hystrix.ProviderFeignClientHystrixFallback;

@FeignClient(name = "provider", fallback = ProviderFeignClientHystrixFallback.class)
public interface ProviderFeignClient {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello();

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi();
}
