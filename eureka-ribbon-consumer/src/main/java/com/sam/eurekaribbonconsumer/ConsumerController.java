package com.sam.eurekaribbonconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sam on 17-11-27.
 */
@RestController
public class ConsumerController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/ribbon-consumer", method = RequestMethod.GET)
    public String index(){
        return "消费HelloService: "+ restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }
}
