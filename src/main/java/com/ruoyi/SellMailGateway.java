package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(value = {"com.ruoyi.dao.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
public class SellMailGateway {

	public static void main(String[] args) {
		SpringApplication.run(SellMailGateway.class, args);
	}

}