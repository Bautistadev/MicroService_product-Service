package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.model.BrandDTO;
import com.Microservice.productService.model.BrandRequestDTO;

public interface BrandMapper {

    /**
     * @Param: BrandEntity
     * @Return: BrandDTO
     * */
    public BrandDTO map(BrandEntity brandEntity);

    /**
     * @Param: BrandDTO
     * @Return: BrandEntity
     * */
    public BrandEntity map(BrandDTO brandDTO);

    /**
     * @Param: BrandRequestDTO
     * @Return: BrandEntity
     * */
    public BrandEntity map(BrandRequestDTO brandRequestDTO);
}
