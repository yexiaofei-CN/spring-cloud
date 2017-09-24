package com.springcloud.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxf on 2017/9/24.
 */
@RefreshScope
@RestController
public class ConfigC {

    @Value("${from}")
   private String from;

    @RequestMapping(value = "/from")
    public String from(){
        System.out.println("from"+from);
        return this.from;
    }
}
