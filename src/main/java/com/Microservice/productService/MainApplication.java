package com.Microservice.productService;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.Microservice.productService"})
@EnableDiscoveryClient
@EnableFeignClients
public class MainApplication implements CommandLineRunner {


	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


	}
}
