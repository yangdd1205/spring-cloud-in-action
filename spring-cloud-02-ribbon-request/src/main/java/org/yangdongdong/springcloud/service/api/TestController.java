package org.yangdongdong.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 调用 Spring Cloud 服务
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "callByServerUrl", method = RequestMethod.GET)
	public String callByServerUrl(String name) {
		// 调用地址：http://[请求协议头] client [服务名] / [context-path] /sayHello [调用方法的地址]
		ResponseEntity<String> response = restTemplate.getForEntity("http://client/sayHello?name=" + name,
				String.class);
		return response.getBody();
	}

	/**
	 * 采用 RestTemplate 方式调用（HTTP方式调用，与 Spring Cloud 调用服务没有一点关系）
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "callByHttpUrl", method = RequestMethod.GET)
	public String callByHttpUrl(String name) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8001/sayHello?name=" + name,
				String.class);
		return response.getBody();
	}
}
