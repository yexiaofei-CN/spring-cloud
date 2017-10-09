package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker //开启断路器
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixRequestBApplication {

	@Bean
	@ConfigurationProperties(prefix = "req.fact")
	public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory(){
		return new HttpComponentsClientHttpRequestFactory();
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate(httpComponentsClientHttpRequestFactory());
	}
	public static void main(String[] args) {
		SpringApplication.run(HystrixRequestBApplication.class, args);
	}
}
