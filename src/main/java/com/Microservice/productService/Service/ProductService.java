package com.Microservice.productService.Service;

import com.Microservice.productService.Entity.ProductEntity;
import com.Microservice.productService.Repository.ProductRepository;
import com.Microservice.productService.Service.Mapper.ProductMapper;
import com.Microservice.productService.model.ProductDTO;
import com.Microservice.productService.model.ProductRequestDTO;
import io.swagger.models.auth.In;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService{

    private ProductRepository productRepository;
    private ProductMapper productMapper;


    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    /**
     * @Operation: save
     * @Param: ProductRequestDTO
     * @Return: ProductDTO
     * */
    @Transactional
    public ProductDTO save(ProductRequestDTO productRequestDTO){
        ProductEntity productDB = this.productMapper.map(productRequestDTO);
        this.productRepository.save(productDB);
        return this.productMapper.map(productDB);
    }
    @Transactional
    public ProductDTO save(ProductDTO productDTO){
        ProductEntity productDB = this.productMapper.map(productDTO);
        this.productRepository.save(productDB);
        return this.productMapper.map(productDB);
    }

    /**
     * @Operation: retrieve all product
     * @Param: -
     * @Return: ProductDTO List
     * */
    @Transactional
    public List<ProductDTO> retrieveAll(){
        List<ProductDTO> productDTOList = this.productRepository.findAll().stream().map(e->{
            return this.productMapper.map(e);
        }).collect(Collectors.toList());

        return productDTOList;
    }

    /**
     * @Operation: retrieve product by id
     * @Param: Integer
     * @Return: ProductDTO
     * */
    @Transactional
    public ProductDTO retrieveById(Integer id){
        return this.productMapper.map(this.productRepository.findById(id).get());
    }

    @Transactional
    public List<ProductDTO> retrieveByName(String name){
        return this.productRepository.findByName(name).stream().map(e -> this.productMapper.map(e)).collect(Collectors.toList());
    }
    @Transactional
    public void remove(Integer id){
        this.productRepository.deleteById(id);
    }


}
