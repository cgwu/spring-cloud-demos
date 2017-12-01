package com.sam.rabbitmqhello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by sam on 17-12-1.
 */
@Component
@Slf4j
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message = "hello(你好) " + LocalDateTime.now();
        log.info("发送者 : " + message);
        this.rabbitTemplate.convertAndSend("hello-key", message);
    }
}
