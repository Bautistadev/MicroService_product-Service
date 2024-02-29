package com.Microservice.productService.Service;

import com.Microservice.productService.Entity.PriceEntity;
import com.Microservice.productService.Repository.PriceRepository;
import com.Microservice.productService.Service.Mapper.PriceMapper;
import com.Microservice.productService.model.PriceDTO;
import com.Microservice.productService.model.PriceRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {

    private PriceRepository priceRepository;
    private PriceMapper priceMapper;


    public PriceService(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    /**
     * @Operation: save
     * @Param: PriceRequestDTO
     * @Return: PriceDTO
     * */
    public PriceDTO save(PriceRequestDTO priceRequestDTO){
        PriceEntity priceDB = this.priceMapper.map(priceRequestDTO);
        PriceDTO priceDTO = this.priceMapper.map(this.priceRepository.save(priceDB));
        System.out.println(priceDTO);
        return priceDTO;
    }

    /**
     * @Operation: retrieve all prices
     * @Param: -
     * @Return: PriceDTO List
     * */
    public List<PriceDTO> retriveAll(){
        List<PriceDTO> response = this.priceRepository.findAll().stream().map(e ->{
            return this.priceMapper.map(e);
        }).collect(Collectors.toList());

        return response;
    }

    /**
     * @Operation: retrieve by id
     * @Param: Integer
     * @Return: PriceDTO
     * */
    public PriceDTO retriveById(Integer id){
        return this.priceMapper.map(this.priceRepository.findById(id).get());
    }
}
