package org.yangdongdong.springcloud.service.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${info}")
    private String info;

    @RequestMapping(value = "/getInfo")
    public String getInfo() {
        return this.info;
    }

}
