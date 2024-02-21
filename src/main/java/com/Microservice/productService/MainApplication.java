package com.Microservice.productService;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.Repository.BrandRepository;
import com.Microservice.productService.Repository.ProductRepository;
import com.Microservice.productService.Service.BrandService;
import com.Microservice.productService.Service.ProductService;
import com.Microservice.productService.model.*;
import com.Microservice.productService.model.BrandRequestDTO;
import com.Microservice.productService.model.ProductRequestDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.Microservice.productService"})
@EnableDiscoveryClient
public class MainApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
		/*
		ProductRequestDTO productRequestDTO = new ProductRequestDTO()
				.name("Jamon Cocido")
				.brand(new BrandDTO().id(1))
				.price(BigDecimal.valueOf(1900))
				.status(ProductRequestDTO.StatusEnum.ENABLE)
				.dateCreated(LocalDate.now());

		ProductRepository brandRepository = ctx.getBean(ProductRepository.class);
		//brandRepository.save(productRequestDTO);

		System.out.println(brandRepository.findAll());*/
	}

}
