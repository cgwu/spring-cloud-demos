package com.sam.guavademo;


import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by sam on 17-12-7.
 */
@Slf4j
public class RateLimiterDemo {

    static RateLimiter limiter = RateLimiter.create(2.0); // 每秒调用2次
//    static RateLimiter limiter = RateLimiter.create(0.5); // 每秒调用0.5次，即2秒调用一次

    static void doSth(){
        log.info("do something");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            limiter.acquire();
            log.info("Hello");
        }
        log.info("main done.");
    }
}
