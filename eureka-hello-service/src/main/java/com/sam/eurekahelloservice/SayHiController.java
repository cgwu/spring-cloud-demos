package com.sam.eurekahelloservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
