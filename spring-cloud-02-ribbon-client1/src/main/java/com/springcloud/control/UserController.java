package com.springcloud.control;

import com.springcloud.entity.User;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yxf on 2017/9/10.
 */
@RestController
public class UserController {


    @RequestMapping(value = "/getUser", method = {RequestMethod.GET})
    public User getUser(@RequestParam("id") String id) {
        System.err.println("client1 GET-------------" + id);
        return new User(id, "20", "张三");
    }

    @RequestMapping(value = "/retry", method = {RequestMethod.GET})
    public String retry() {
        System.err.println("client1  1 call-------------");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "client 1";
    }

}
