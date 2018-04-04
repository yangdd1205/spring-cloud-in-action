package org.yangdongdong.springcloud.service.api;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        System.out.println("provider-a hello feign!");
        return "hello feign!";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("provider-a hi feign!");
        return "hi feign!";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String getData(@PathVariable("id") String id) {
        return "PathVariable id: " + id;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam("id") String id) {
        return "RequestParam id: " + id;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        return user.getId() + ":" + user.getName();
    }

    @RequestMapping(value = "/addFormRequestBody", method = RequestMethod.POST)
    public String addFormRequestBody(@RequestBody User user) {
        return "From body " + user.getId() + ":" + user.getName();
    }

    static class User {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
