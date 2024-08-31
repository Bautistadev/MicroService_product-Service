package com.Microservice.productService.Repository;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Integer> {
    public List<BrandEntity> findByName(String name);
}

