package org.yangdongdong.springcloud;

import org.springframework.web.client.RestTemplate;

public class TestCircuitBreaker {
    public static void main(String[] args) throws Exception {
        RestTemplate rt = new RestTemplate();
        for (int i = 0; i < 15; i++) {
            new Thread(() -> {
                System.out.println(
                        rt.getForEntity("http://localhost:9001//hystrix-circuit-breaker", String.class).getBody());

            }).start();
        }
    }
}
