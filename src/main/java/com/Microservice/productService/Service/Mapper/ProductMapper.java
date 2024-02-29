package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.model.ProductDTO;
import com.Microservice.productService.model.ProductRequestDTO;

public interface ProductMapper {

    /**
     * @Param: ProductEntity
     * @Return: ProductDTO
     * */
    public ProductDTO map(ProductEntity productEntity);

    /**
     * @Param: ProductDTO
     * @Return: ProductEntity
     * */
    public ProductEntity map(ProductDTO productDTO);

    /**
     * @Param: ProductRequestDTO
     * @Return: ProductEntity
     * */
    public ProductEntity map(ProductRequestDTO productRequestDTO);
}
