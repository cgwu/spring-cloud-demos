package com.sam.feignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("hello-service") // HELLO-SERVICE不区分大小写
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/sayhi", method = RequestMethod.GET)
    String sayhi(@RequestParam("name") String name);

    @RequestMapping(value = "/sayhi2", method = RequestMethod.GET)
    UserInfo sayhi2(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/sayhi3", method = RequestMethod.POST)
    String sayhi3(@RequestBody UserInfo user);
}
