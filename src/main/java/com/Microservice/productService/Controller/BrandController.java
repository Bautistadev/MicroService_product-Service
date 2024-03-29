package com.Microservice.productService.Controller;

import com.Microservice.productService.BrandsApiDelegate;
import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.Repository.BrandRepository;
import com.Microservice.productService.Service.BrandService;
import com.Microservice.productService.Service.Mapper.BrandMapper;
import com.Microservice.productService.model.BrandDTO;
import com.Microservice.productService.model.BrandListDTO;
import com.Microservice.productService.model.BrandRequestDTO;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products/")
public class BrandController implements BrandsApiDelegate {
    private BrandService brandService;


    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return BrandsApiDelegate.super.getRequest();
    }

    /**
     * POST
     * */
    @Override
    public ResponseEntity<BrandDTO> createBrand(BrandRequestDTO brandRequestDTO) {
        BrandDTO response = this.brandService.save(brandRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<Void> deleteByBrandId(Integer brandId) {
        return BrandsApiDelegate.super.deleteByBrandId(brandId);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<BrandListDTO> retrieveAllBrand() {
        BrandListDTO response = new BrandListDTO().items(this.brandService.retrieveAll());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<BrandDTO> retrieveBrandById(Integer brandId) {
        BrandDTO response = this.brandService.retrieveById(brandId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<BrandDTO> retrieveBrandByName(String brandName) {
        return BrandsApiDelegate.super.retrieveBrandByName(brandName);
    }

    /**
     * POST
     * */
    @Override
    public ResponseEntity<BrandDTO> updateBrand(BrandDTO brandDTO) {
        return BrandsApiDelegate.super.updateBrand(brandDTO);
    }
}
