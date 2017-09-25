package com.springcloud.control;

import com.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
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

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public String get() {
        ResponseEntity<User> respone = restTemplate.getForEntity("http://client-service/getUser?id={1}", User.class, "01");
        System.err.println("userName"+ respone.getBody().getName());
        return "------get----";
    }
}
