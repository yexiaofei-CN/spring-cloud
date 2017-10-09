package com.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine			//启用收集断路器集群服务功能
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixTurbineApplication {

	// 监控台地址: http://localhost:8011/hystrix

	// 查看[我们要监控哪一个断路器服务]什么样的数据,写上具体的地址: http://localhost:2003/hystrix.stream

	// 要监控的turbine地址[监控hystrix-request服务]: http://localhost:3000/turbine.stream
	// turbine是集群监控 dashboard中输入得是turbine得地址 turbine是集群得集合
	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineApplication.class, args);
	}
}
