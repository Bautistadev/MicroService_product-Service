package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.model.BrandDTO;
import com.Microservice.productService.model.BrandRequestDTO;
import com.Microservice.productService.model.ProductDTO;

import java.util.stream.Collectors;

public class BrandMapperImplements implements BrandMapper{

    /**
     * @Param: BrandEntity
     * @Return: BrandDTO
     * */
    @Override
    public BrandDTO map(BrandEntity brandEntity) {
        BrandDTO brandDTO = new BrandDTO()
                .id(brandEntity.getId())
                .name(brandEntity.getName())
                .dateCreated(brandEntity.getDateCreated());

        return brandDTO;
    }

    /**
     * @Param: BrandDTO
     * @Return: BrandEntity
     * */
    @Override
    public BrandEntity map(BrandDTO brandDTO) {
        BrandEntity brandEntity = BrandEntity.builder()
                .id(brandDTO.getId())
                .name(brandDTO.getName())
                .dateCreated(brandDTO.getDateCreated())
                .build();

        return brandEntity;
    }

    /**
     * @Param: BrandRequestDTO
     * @Return: BrandEntity
     * */
    @Override
    public BrandEntity map(BrandRequestDTO brandRequestDTO) {
        BrandEntity brandEntity = BrandEntity.builder()
                .name(brandRequestDTO.getName().toUpperCase())
                .dateCreated(brandRequestDTO.getDateCreated())
                .build();

        return brandEntity;
    }
}
