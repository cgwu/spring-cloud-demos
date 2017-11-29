package com.sam.eurekahelloservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sam on 17-11-27.
 */
@RestController
@Slf4j
public class SayHiController {

    @RequestMapping(value = "/sayhi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        log.info("调用say hi called: {}", name);
        return "您好：" + name;
    }

    // RequestHeader有中文乱码的问题!
    @RequestMapping(value = "/sayhi2", method = RequestMethod.GET)
    public UserInfo sayHi(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        log.info("name: {}, age: {}", name, age);
        return new UserInfo(name, age);
    }

    @RequestMapping(value = "/sayhi3", method = RequestMethod.POST)
    public String sayHi(@RequestBody UserInfo user) {
        return "您好3：" + user;
    }

}
