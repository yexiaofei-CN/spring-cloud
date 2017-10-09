package com.springcloud.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxf on 2017/9/13.
 */
@RestController
public class HelloControl {


    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        System.err.println("hello hystrix ....");
        return "hello hystrix ...";
    }

    @RequestMapping(value = "/action",method = {RequestMethod.GET})
    public String action() throws InterruptedException {
        Thread.sleep(5000);
        System.err.println("action hystrix ....");
        return "action hystrix ...";
    }
}
