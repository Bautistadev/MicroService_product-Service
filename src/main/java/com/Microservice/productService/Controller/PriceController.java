package com.Microservice.productService.Controller;

import com.Microservice.productService.PricesApiDelegate;
import com.Microservice.productService.Service.PriceService;
import com.Microservice.productService.model.PriceDTO;
import com.Microservice.productService.model.PriceListDTO;
import com.Microservice.productService.model.PriceRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products/")
public class PriceController implements PricesApiDelegate {

    private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PricesApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<PriceDTO> createPrice(PriceRequestDTO priceRequestDTO) {
        PriceDTO response = this.priceService.save(priceRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<PriceListDTO> retriveAllPrice() {
        PriceListDTO respose =  new PriceListDTO().items(this.priceService.retriveAll());
        return ResponseEntity.status(HttpStatus.OK).body(respose);
    }

    @Override
    public ResponseEntity<PriceDTO> updatePrice(PriceDTO priceDTO) {

        return PricesApiDelegate.super.updatePrice(priceDTO);
    }
}
