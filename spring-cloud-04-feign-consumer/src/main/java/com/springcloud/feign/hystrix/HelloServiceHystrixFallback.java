package com.springcloud.feign.hystrix;

import com.springcloud.entity.User;
import com.springcloud.feign.HelloService;
import org.springframework.stereotype.Component;

/**
 * Created by yxf on 2017/9/15.
 */
@Component
public class HelloServiceHystrixFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String action() {
        System.out.println("----action执行降级策略----");
        return "----action执行降级策略----";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
