package com.sam.feignconsumer;

import com.sam.helloserviceapi.HelloRefactorService;
import com.sam.helloserviceapi.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sam on 17-11-29.
 */
@Component
@RequestMapping("/refactor-fallback")
public class HelloRefactorFallback implements ConsumerHelloService {
    @Override
    public String sayhi() {
        return "fallback message";
    }

    @Override
    public String sayhi(@RequestParam("name") String name) {
        return "fallback message with name";
    }

    @Override
    public UserEntity sayhi(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new UserEntity("fallback", 0);
    }

    @Override
    public String sayhi(@RequestBody UserEntity user) {
        return "fallback message with UserEntity";
    }
}
