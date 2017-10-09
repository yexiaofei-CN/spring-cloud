package com.springcloud.controller;

import com.springcloud.entity.User;
import com.springcloud.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * Created by yxf on 2017/9/15.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String helloConsumer() {
        return helloService.hello()+"\n";
    }

    @RequestMapping(value = "/action", method = {RequestMethod.GET})
    public String helloAction() {
        return helloService.action();
    }

    @RequestMapping(value = "/feign-consumer", method = {RequestMethod.GET})
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("FF")).append("\n");
        sb.append(helloService.hello("FF", 20)).append("\n");
        sb.append(helloService.hello(new User("FF", 22))).append("\n");
        return sb.toString();
    }
}
