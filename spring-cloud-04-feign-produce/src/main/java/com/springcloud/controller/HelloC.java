package com.springcloud.controller;

import com.springcloud.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yxf on 2017/9/16.
 */
@RestController
public class HelloC {
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
       return "Hello"+name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name,@RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello"+user.getName()+","+user.getAge();
    }
}
