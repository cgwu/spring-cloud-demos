package com.sam.lombokdemo;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by sam on 17-11-28.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        User u = new User();
        u.setAge(10);
        u.setName("sam吴");
        System.out.println(u);
        log.info("Hello,日志"+ log.getClass());

        User  ua = new User("dan",30);
        System.out.println(ua);
        User  un = new User("only name");
        System.out.println(un);
    }
}
