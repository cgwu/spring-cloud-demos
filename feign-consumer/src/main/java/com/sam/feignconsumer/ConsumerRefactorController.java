package com.sam.feignconsumer;

import com.sam.helloserviceapi.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sam on 17-11-27.
 */
@RestController
@Slf4j
@RequestMapping("/refactor")
public class ConsumerRefactorController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConsumerHelloService helloService;

    @RequestMapping(value = "/hello-consumer", method = RequestMethod.GET)
    public String hello() {
        return helloService.sayhi();
    }


    @RequestMapping(value = "/sayhi-consumer", method = RequestMethod.GET)
    public String sayHiConsumer(String name) {
        log.info("refactor sayHiConsumer: {}", name);
        return "refactor 调用HelloService.sayhi(): " + helloService.sayhi(name);
    }

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String sayHiFeignConsumer() {
        String result1 = helloService.sayhi("五五wuwu");
        log.info("sayhi4: {}", result1);
        UserEntity user = helloService.sayhi("张三zhangsan", 30);
        log.info("sayhi5: {}", user.toString());
        String result3 = helloService.sayhi(new UserEntity("李四", 40));
        log.info("sayhi6: {}", result3);
        return String.join("<br>", "调用HelloService.sayhi 1 2 3: "
                , result1, user.toString(), result3);
    }
}
