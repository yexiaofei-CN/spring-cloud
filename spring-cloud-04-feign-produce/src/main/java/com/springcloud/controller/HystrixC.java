package com.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxf on 2017/9/13.
 */
@RestController
public class HystrixC {

    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello() throws InterruptedException {
        System.err.println("hello hystrix ....");
        return "hello hystrix ...";
    }

    @RequestMapping(value = "/action",method = {RequestMethod.GET})
    public String action() throws InterruptedException {
        Thread.sleep(4000);
        System.err.println("action hystrix ....");
        return "action hystrix ...";
    }
}
