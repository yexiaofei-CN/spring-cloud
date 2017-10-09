package com.springcloud.controller;

import com.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxf on 2017/9/13.
 */
@RestController
public class HystrixC {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello(){
        return helloService.hello();
    }

    @RequestMapping(value = "/hystrix-handler",method = {RequestMethod.GET})
    public String handler(){
        return helloService.handler();
    }

    @RequestMapping(value = "/hystrix-action",method = {RequestMethod.GET})
    public String action(){
        return helloService.action();
    }


}
