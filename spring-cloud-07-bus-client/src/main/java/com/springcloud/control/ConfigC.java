package com.springcloud.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.util.RequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yxf on 2017/9/19.
 */

@RefreshScope
@RestController
public class ConfigC {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from")
    public String from() {
        System.err.println("from" + from);
        return this.from;
    }
}
