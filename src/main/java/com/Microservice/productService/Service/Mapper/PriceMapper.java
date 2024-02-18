package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.PriceEntity;
import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.model.PriceDTO;
import com.Microservice.productService.model.PriceRequestDTO;
import com.Microservice.productService.model.ProductDTO;

public interface PriceMapper {
    public PriceDTO map(PriceEntity priceEntity);
    public PriceEntity map(PriceDTO priceDTO);
    public PriceEntity map(PriceRequestDTO priceRequestDTO);
}
