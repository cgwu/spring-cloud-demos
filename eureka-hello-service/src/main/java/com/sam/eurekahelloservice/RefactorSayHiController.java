package com.sam.eurekahelloservice;

import com.sam.helloserviceapi.HelloRefactorService;
import com.sam.helloserviceapi.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created by sam on 17-11-27.
 */
@RestController
@Slf4j
public class RefactorSayHiController implements HelloRefactorService {

    @Override
    public String sayhi() {
        return LocalDateTime.now().toString() + " says: 您好!";
    }

    public String sayhi(@RequestParam("name") String name) {
        log.info("refactor调用say hi called: {}", name);
        return "您好：" + name;
    }

    // RequestHeader有中文乱码的问题!
    public UserEntity sayhi(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        log.info("refactor name: {}, age: {}", name, age);
        return new UserEntity(name, age);
    }

    public String sayhi(@RequestBody UserEntity user) {
        log.info("refactor sayhi RequestBody");
        return "您好3：" + user;
    }

}
