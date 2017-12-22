package org.yangdongdong.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello(String name) {
		System.out.println("client 2");
		return "hello " + name;
	}

}
