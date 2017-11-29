package com.sam.feignconsumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sam on 17-11-27.
 */
@RestController
@Slf4j
public class ConsumerController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello-consumer", method = RequestMethod.GET)
    public String hello() {
        return helloService.hello();
    }


    @RequestMapping(value = "/sayhi-consumer", method = RequestMethod.GET)
    public String sayHiConsumer(String name) {
        log.info("sayHiConsumer: {}", name);
        return "调用HelloService.sayhi(): " + helloService.sayhi(name);
    }

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String sayHiFeignConsumer() {
        String result1 = helloService.sayhi("五五wuwu");
        log.info("sayhi1: {}", result1);
        UserInfo user = helloService.sayhi2("张三zhangsan", 30);
        log.info("sayhi2: {}", user.toString());
        String result3 = helloService.sayhi3(new UserInfo("李四", 40));
        log.info("sayhi3: {}", result3);
        return "调用HelloService.sayhi 1 2 3: " + result1 + user.toString() + result3;
    }
}
