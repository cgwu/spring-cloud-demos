package com.sam.helloserviceapi;

import org.springframework.web.bind.annotation.*;

/**
 * Created by sam on 17-11-29.
 */
@RequestMapping("/refactor")
public interface HelloRefactorService {
    @RequestMapping("/hello")
    String sayhi();

    @RequestMapping(value = "/sayhi4", method = RequestMethod.GET)
    String sayhi(@RequestParam("name") String name);

    @RequestMapping(value = "/sayhi5", method = RequestMethod.GET)
    UserEntity sayhi(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/sayhi6", method = RequestMethod.POST)
    String sayhi(@RequestBody UserEntity user);
}
