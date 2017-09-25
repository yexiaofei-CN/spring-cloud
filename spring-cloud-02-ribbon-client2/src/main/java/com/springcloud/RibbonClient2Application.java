package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RibbonClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClient2Application.class, args);
	}
}
