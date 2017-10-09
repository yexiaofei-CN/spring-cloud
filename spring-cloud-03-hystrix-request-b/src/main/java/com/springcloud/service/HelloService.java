package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.undertow.util.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yxf on 2017/9/13.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloFailback")
    public String hello() {
      return  restTemplate.getForObject("http://client-service/hello",String.class);
    }

    public String helloFailback(){
        System.out.println("----执行降级策略----");
        return "----执行降级策略----";
    }

    @HystrixCommand(fallbackMethod = "handlerFailback", ignoreExceptions = {BadRequestException.class})
    public String handler() {
        throw new RuntimeException("运行时异常");
    }

    public String handlerFailback(Throwable e){
        System.err.println("异常信息:"+ e.getMessage());
        return "获取异常信息并可以做具体的降级处理";
    }

    @HystrixCommand(
            commandKey = "actionKey",
            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", /*KEY*/ value = "8000" /*VALUE*/)},
            fallbackMethod = "actionFailback")
    public String action() {
       return restTemplate.getForObject("http://client-service/action",String.class);
    }

    public String actionFailback(){
        System.out.println("----执行降级策略----");
        return "----执行降级策略----";
    }
}
