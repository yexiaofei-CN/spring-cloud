package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class BusServerApplication {

	//刷新配置地址: post: http://localhost:4001/bus/refresh
	public static void main(String[] args) {
		SpringApplication.run(BusServerApplication.class, args);
	}
}
