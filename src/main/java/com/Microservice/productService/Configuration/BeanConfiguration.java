package com.Microservice.productService.Configuration;

import com.Microservice.productService.Repository.BrandRepository;
import com.Microservice.productService.Repository.PriceRepository;
import com.Microservice.productService.Repository.ProductRepository;
import com.Microservice.productService.Service.Mapper.*;
import com.Microservice.productService.Service.BrandService;
import com.Microservice.productService.Service.PriceService;
import com.Microservice.productService.Service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    /**
     * MAPPER
     * */
    @Bean
    public BrandMapper brandMapper(){
        return new BrandMapperImplements();
    }

    @Bean
    public ProductMapper productMapper(){
        return new ProductMapperImplements();
    }

    @Bean
    public PriceMapper priceMapper(){
        return new PriceMapperImplements();
    }

    /**
     * SERVER
     * */
    @Bean
    public BrandService brandService(BrandRepository brandRepository, BrandMapper brandMapper){
        return new BrandService(brandRepository,brandMapper);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository,ProductMapper productMapper){
        return new ProductService(productRepository,productMapper);
    }

    @Bean
    public PriceService priceService(PriceRepository priceRepository,PriceMapper priceMapper){
        return new PriceService(priceRepository,priceMapper);
    }
}
