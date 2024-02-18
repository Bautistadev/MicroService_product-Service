package com.Microservice.productService.Repository;

import com.Microservice.productService.Entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Integer> {
}
