package com.springcloud.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxf on 2017/9/9.
 */
@RestController
public class IndexController {


    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello(){
        return "hello world";
    }
}
