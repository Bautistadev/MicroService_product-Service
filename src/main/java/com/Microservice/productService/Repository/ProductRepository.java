package com.Microservice.productService.Repository;

import com.Microservice.productService.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    public List<ProductEntity> findByName(String name);
}
