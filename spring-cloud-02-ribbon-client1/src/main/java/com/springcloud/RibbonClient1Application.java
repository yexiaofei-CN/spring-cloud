package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RibbonClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClient1Application.class, args);
	}
}
