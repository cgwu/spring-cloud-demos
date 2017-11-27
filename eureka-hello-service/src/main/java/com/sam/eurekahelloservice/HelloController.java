package com.sam.eurekahelloservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sam on 17-11-27.
 */
@RestController
public class HelloController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        LOG.info("/hello, host:"+instance.getHost()+", service_id:"+instance.getServiceId());
        return "Hello, 世界!";
    }
}
