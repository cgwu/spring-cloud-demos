package com.sam.feignconsumer;

import com.sam.helloserviceapi.HelloRefactorService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by sam on 17-11-29.
 */
@FeignClient(value = "HELLO-SERVICE", fallback = HelloRefactorFallback.class)
public interface ConsumerHelloService extends HelloRefactorService {
}
