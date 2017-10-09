package com.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients
@EnableCircuitBreaker //开启断路器
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApplication {


    @Bean
    Logger.Level feignLoggerLevel() {
        /**
         *  NONE: 不记录任何信息
         *  BASIE:仅记录请求方法，URL以及响应状态码和执行时间
         *  HEADERS:除了记录BASIE级别得信息之外，还会记录请求和响应得头信息
         *  FULL：记录所有请求与响应得明细，包括头信息，请求体，元数据等。
         */
        return Logger.Level.FULL;
    }

    @Bean
    @ConfigurationProperties(prefix = "req.fact")
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(httpComponentsClientHttpRequestFactory());
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
