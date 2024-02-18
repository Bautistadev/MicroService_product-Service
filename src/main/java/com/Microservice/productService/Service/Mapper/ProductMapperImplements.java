package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.Entity.Enums.Status;
import com.Microservice.productService.Entity.PriceEntity;
import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.model.BrandDTO;
import com.Microservice.productService.model.PriceDTO;
import com.Microservice.productService.model.ProductDTO;
import com.Microservice.productService.model.ProductRequestDTO;

import java.math.BigDecimal;
import java.util.stream.Collectors;

/**
 * Mapper class
 *
 * */

public class ProductMapperImplements implements ProductMapper{

    /**
     * @param productEntity
     * @return productDTO
     * */
    @Override
    public ProductDTO map(ProductEntity productEntity) {

        ProductDTO productDTO = new ProductDTO()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .dateCreated(productEntity.getDateCreated())
                .price(BigDecimal.valueOf(productEntity.getPrice()));

        productDTO.brand(new BrandDTO()
                .id(productEntity.getBrand().getId())
                .name(productEntity.getBrand().getName())
                .dateCreated(productEntity.getBrand().getDateCreated()));


        if(productEntity.getStatus().name().equals("ENABLE"))
            productDTO.setStatus(ProductDTO.StatusEnum.ENABLE);
        else if (productEntity.getStatus().name().equals("DISABLE"))
            productDTO.setStatus(ProductDTO.StatusEnum.DISABLE);
        else
            productDTO.setStatus(ProductDTO.StatusEnum.SUSPENDED);

        return productDTO;
    }

    /**
     * @param productDTO
     * @return productEntity
     * */

    @Override
    public ProductEntity map(ProductDTO productDTO) {

        ProductEntity productEntity = ProductEntity.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .dateCreated(productDTO.getDateCreated())
                .price(Float.valueOf(productDTO.getPrice().toString())).build();

        productEntity.setBrand(BrandEntity.builder()
                .id(productDTO.getBrand().getId())
                .name(productDTO.getBrand().getName())
                .dateCreated(productDTO.getBrand().getDateCreated()).build());



        if(productDTO.getStatus().name().equals("ENABLE"))
            productEntity.setStatus(Status.ENABLE);
        else if (productDTO.getStatus().name().equals("DISABLE"))
            productEntity.setStatus(Status.DISABLE);
        else
            productEntity.setStatus(Status.SUSPENDED);

        return productEntity;
    }

    @Override
    public ProductEntity map(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(productRequestDTO.getName())
                .dateCreated(productRequestDTO.getDateCreated())
                .price(Float.valueOf(productRequestDTO.getPrice().toString())).build();

        productEntity.setBrand(BrandEntity.builder()
                .id(productRequestDTO.getBrand().getId())
                .name(productRequestDTO.getBrand().getName())
                .dateCreated(productRequestDTO.getBrand().getDateCreated()).build());

        if(productRequestDTO.getStatus().name().equals("ENABLE"))
            productEntity.setStatus(Status.ENABLE);
        else if (productRequestDTO.getStatus().name().equals("DISABLE"))
            productEntity.setStatus(Status.DISABLE);
        else
            productEntity.setStatus(Status.SUSPENDED);

        return productEntity;
    }
}
