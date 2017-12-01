package com.sam.rabbitmqhello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by sam on 17-12-1.
 */
//@Component
@Slf4j
@RabbitListener(queues = "hello-key")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        log.info("接收者 : " + message);
    }

}
