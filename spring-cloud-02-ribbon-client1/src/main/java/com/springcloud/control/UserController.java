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

    @RequestMapping(value = "/postUser", method = {RequestMethod.POST})
    public User postUser(@RequestParam("id") String id) {
        System.err.println("client1 POST-------------" + id);
        return new User(id, "20", "张三");
    }

    @RequestMapping(value = "/instertUser",produces = {"application/json;charset=UTF-8"},consumes = {"application/json;charset=UTF-8 "},method = {RequestMethod.POST})
    public User instertUser(@RequestBody User user) {
        System.err.println("client1 -------------" + user.getName());
        return user;
    }

    @RequestMapping(value = "/putUser",produces = {"application/json;charset=UTF-8"}, method = {RequestMethod.PUT})
    public void putUser(@RequestBody User user, @RequestParam("id") String id) {
        System.err.println("client1 PUT-------------" + user.getName());
    }

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.DELETE})
    public void deleteUser(@RequestParam("id") String id) {
        System.err.println("client1  DELETE-------------" + id);
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
