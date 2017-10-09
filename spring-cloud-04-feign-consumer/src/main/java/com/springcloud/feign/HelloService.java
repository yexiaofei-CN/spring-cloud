package com.springcloud.feign;

import com.springcloud.entity.User;
import com.springcloud.feign.hystrix.HelloServiceHystrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yxf on 2017/9/15.
 */
@FeignClient(name = "feign-produce", fallback = HelloServiceHystrixFallback.class)
public interface HelloService {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    String hello();

    @RequestMapping(value = "/action", method = {RequestMethod.GET})
    String action();

    @RequestMapping(value = "/hello1", method = {RequestMethod.GET})
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
