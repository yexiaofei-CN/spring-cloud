package com.springcloud.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yxf on 2017/9/11.
 */
@RestController
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/retry", method = {RequestMethod.GET})
    @HystrixCommand(fallbackMethod = "retryFailback")
    public String retry(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://client-service/retry", String.class);
        System.err.println("body:" + response.getBody());
        return "----- retry ok -----";
    }

    public String retryFailback(){
        System.err.println("-----启动降级策略----");
        return "-----启动降级策略----";
    }
}
