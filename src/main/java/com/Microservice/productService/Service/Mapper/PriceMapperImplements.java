package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.PriceEntity;
import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.model.PriceDTO;
import com.Microservice.productService.model.PriceRequestDTO;
import com.Microservice.productService.model.ProductDTO;

import java.math.BigDecimal;

public class PriceMapperImplements implements PriceMapper{



    /**
     * @Param: PriceEntity
     * @Return: PriceDTO
     * */
    @Override
    public PriceDTO map(PriceEntity priceEntity) {

        PriceDTO priceDTO = new PriceDTO()
                .id(priceEntity.getId())
                .price(BigDecimal.valueOf(priceEntity.getPrice()))
                .dateCreated(priceEntity.getDateCreated())
                .product(new ProductDTO()
                        .id(priceEntity.getProduct().getId())
                        .name(priceEntity.getProduct().getName()));
        return priceDTO;
    }

    /**
     * @Param: PriceDTO
     * @Return: PriceEntity
     * */
    @Override
    public PriceEntity map(PriceDTO priceDTO) {
        PriceEntity priceEntity = PriceEntity.builder()
                .id(priceDTO.getId())
                .price(Float.valueOf(priceDTO.getPrice().toString()))
                .dateCreated(priceDTO.getDateCreated())
                .product(ProductEntity.builder()
                        .id(priceDTO.getProduct().getId())
                        .name(priceDTO.getProduct().getName())
                        .build())
                .build();
        return priceEntity;
    }


    /**
     * @Param: PriceRequestDTO
     * @Return: PriceEntity
     * */
    @Override
    public PriceEntity map(PriceRequestDTO priceRequestDTO) {
        PriceEntity priceEntity = PriceEntity.builder()
                .price(Float.valueOf(priceRequestDTO.getPrice().toString()))
                .dateCreated(priceRequestDTO.getDateCreated())
                .product(ProductEntity.builder()
                        .id(priceRequestDTO.getProduct().getId())
                        .name(priceRequestDTO.getProduct().getName())
                        .build())
                .build();
        return priceEntity;
    }
}
