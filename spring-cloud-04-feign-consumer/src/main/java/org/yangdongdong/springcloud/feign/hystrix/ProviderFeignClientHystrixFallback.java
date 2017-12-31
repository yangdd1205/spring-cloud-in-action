package org.yangdongdong.springcloud.feign.hystrix;

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

}
