package org.yangdongdong.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "retry", method = RequestMethod.GET)
    public String retry() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://client/retry", String.class);
        String result = response.getBody();
        System.err.println("result: " + result);
        return "result: " + result;
    }
}
