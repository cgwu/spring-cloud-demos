package com.sam.rabbitmqhello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


@Slf4j
@EnableBinding(Sink.class)
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(String payload) {
        log.info("接收 : " + payload);
    }

}
