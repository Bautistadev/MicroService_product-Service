package com.Microservice.productService;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.Repository.BrandRepository;
import com.Microservice.productService.Repository.ProductRepository;
import com.Microservice.productService.Service.BrandService;
import com.Microservice.productService.Service.ProductService;
import com.Microservice.productService.model.*;
import com.Microservice.productService.model.BrandRequestDTO;
import com.Microservice.productService.model.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.Microservice.productService"})
@EnableDiscoveryClient
@EnableFeignClients
public class MainApplication implements CommandLineRunner {

	@Value(value = "${app.test.property}")
	private String pro;

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(pro);
	}
}
