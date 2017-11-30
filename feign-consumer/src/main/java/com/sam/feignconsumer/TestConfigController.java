package com.sam.feignconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sam on 17-11-30.
 * 从Spring Cloud Config server中读取配置信息
 */
@RefreshScope
@RestController
@Slf4j
public class TestConfigController {
    @Value("${kall}")
    private String keyAll;

    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        log.info(this.keyAll + " : " + this.from);
        return this.keyAll + " : " + this.from;
    }
}
