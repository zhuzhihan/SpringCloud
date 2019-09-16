package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class Sp06RibbonApplication {

	// 创建 RestTemplate 实例，并存入 spring 容器
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		// 一下代码目前直接写到yml配置中不生效 目前的bug
		SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);// 连接超时则重试
		f.setReadTimeout(1000);// 响应数据等待一秒超时则重试
		return new RestTemplate(f);
		// RestTemplate 中默认的 Factory 实例中，两个超时属性默认是 -1(关闭)，
		// 未启用超时，也不会触发重试
		// return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Sp06RibbonApplication.class, args);
	}

}
