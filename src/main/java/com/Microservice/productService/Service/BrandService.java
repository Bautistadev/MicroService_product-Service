package com.Microservice.productService.Service;

import com.Microservice.productService.Entity.BrandEntity;
import com.Microservice.productService.Repository.BrandRepository;
import com.Microservice.productService.Service.Mapper.BrandMapper;
import com.Microservice.productService.model.BrandDTO;
import com.Microservice.productService.model.BrandRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private BrandMapper brandMapper;

    public BrandService(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    /**
     * @Operation: Save brand
     * @Param: BrandRequestDTO
     * @Return: BrandDTO
     * */
    public BrandDTO save(BrandRequestDTO brandDTO){
        BrandEntity brandDB = this.brandMapper.map(brandDTO);
        this.brandRepository.save(brandDB);
        BrandDTO response = this.brandMapper.map(brandDB);

        return response;
    }

    /**
     * @Operation: retrieve all brands
     * @Param: -
     * @Return: BrandDTO List
     * */
    public List<BrandDTO> retrieveAll(){

        List<BrandDTO> response = this.brandRepository.findAll().stream().map(e ->{
            return this.brandMapper.map(e);
        }).collect(Collectors.toList());

        return response;
    }

    /**
     * @Operation: Retrieve brand by id
     * @Param: Integer
     * @Return: BrandDTO
     * */
    public BrandDTO retrieveById(Integer id){
        return this.brandMapper.map(this.brandRepository.findById(id).get());
    }


}
