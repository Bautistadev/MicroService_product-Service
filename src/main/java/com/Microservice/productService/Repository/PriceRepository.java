package com.Microservice.productService.Repository;

import com.Microservice.productService.Entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity,Integer> {
}
