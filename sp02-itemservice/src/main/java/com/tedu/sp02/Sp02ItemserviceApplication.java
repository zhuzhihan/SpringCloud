package com.tedu.sp02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
@EnableDiscoveryClient//都是能够让注册中心能够发现，扫描到改服务。
@SpringBootApplication
public class Sp02ItemserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp02ItemserviceApplication.class, args);
	}

}
