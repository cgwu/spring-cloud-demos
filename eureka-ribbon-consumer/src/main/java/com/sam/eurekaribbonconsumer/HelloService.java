package com.sam.eurekaribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sam on 17-11-28.
 */
@Service
@Slf4j
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

//    缓存测试未通过 P183《Spring Cloud微服务实战》
//    @CacheResult //(cacheKeyMethod = "getCachedKeyName")
    @HystrixCommand(fallbackMethod = "sayHiFallback")
    public String sayHi(String name) {
        log.info("sayHi called");
        return "消费SayHiService: " + restTemplate.getForEntity("http://HELLO-SERVICE/sayhi?name={0}",
                String.class, name).getBody();
    }

    public String sayHiFallback(String name) {
        log.info("sayHiFallback called");
        return "fallback message:" + name;
    }

//    public String getCachedKeyName(String name) {
//        return "key_" + name;
//    }
}
