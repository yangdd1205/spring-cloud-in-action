package org.yangdongdong.springcloud.feign.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.yangdongdong.springcloud.feign.ProviderFeignClient;

@Component // 不要忘记 @Component 注解
public class ProviderFeignClientHystrixFallback implements ProviderFeignClient {

    @Override
    public String sayHello() {
        return "Hello Fallback";
    }

    @Override
    public String sayHi() {
        return "Hi Fallback";
    }

    @Override
    public String add(String id, String name) {
        return "simple add fallback";
    }

    @Override
    public String addFormRequestBody(Map map) {
        return "add Form RequestBody fallback";
    }

    @Override
    public String getFromPathVariable(String id) {
        return "get from @PathVariable fallback";
    }

    @Override
    public String getFromRequestParam(String id) {
        return "get from @RequestParam fallback";
    }

}
