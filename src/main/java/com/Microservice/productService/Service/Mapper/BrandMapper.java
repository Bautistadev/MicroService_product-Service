package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.model.BrandDTO;
import com.Microservice.productService.model.BrandRequestDTO;

public interface BrandMapper {
    public BrandDTO map(BrandEntity brandEntity);
    public BrandEntity map(BrandDTO brandDTO);
    public BrandEntity map(BrandRequestDTO brandRequestDTO);
}
