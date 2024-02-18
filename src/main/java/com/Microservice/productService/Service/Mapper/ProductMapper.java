package com.Microservice.productService.Service.Mapper;

import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.model.ProductDTO;
import com.Microservice.productService.model.ProductRequestDTO;

public interface ProductMapper {

    public ProductDTO map(ProductEntity productEntity);
    public ProductEntity map(ProductDTO productDTO);
    public ProductEntity map(ProductRequestDTO productRequestDTO);
}
