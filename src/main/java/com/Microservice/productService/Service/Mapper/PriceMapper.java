package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.PriceEntity;
import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.model.PriceDTO;
import com.Microservice.productService.model.PriceRequestDTO;
import com.Microservice.productService.model.ProductDTO;

public interface PriceMapper {

    /**
     * @Param: PriceEntity
     * @Return: PriceDTO
     * */
    public PriceDTO map(PriceEntity priceEntity);

    /**
     * @Param: PriceDTO
     * @Return: PriceEntity
     * */
    public PriceEntity map(PriceDTO priceDTO);

    /**
     * @Param: PriceRequestDTO
     * @Return: PriceEntity
     * */
    public PriceEntity map(PriceRequestDTO priceRequestDTO);
}
