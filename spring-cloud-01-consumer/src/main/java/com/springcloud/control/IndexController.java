package com.springcloud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yxf on 2017/9/9.
 */
@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getAppNameUrl", method = {RequestMethod.GET})
    public String getApplicationNameUrl(){
         ResponseEntity<String> response  = restTemplate.getForEntity("http://provider-service/provider/hello",String.class);
        System.err.println("body:" + response.getBody());
        return "调用成功";
    }

    @RequestMapping(value = "/getUrl", method = {RequestMethod.GET})
    public String getUrl() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response = rest.getForEntity("http://localhost:2001/provider/hello", String.class);
        System.err.println("body:" + response.getBody());
        return "调用成功";
    }
}
