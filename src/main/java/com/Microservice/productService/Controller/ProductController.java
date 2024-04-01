package com.Microservice.productService.Controller;

import com.Microservice.productService.ProductsApiDelegate;
import com.Microservice.productService.Service.PriceService;
import com.Microservice.productService.Service.ProductService;
import com.Microservice.productService.model.PriceRequestDTO;
import com.Microservice.productService.model.ProductDTO;
import com.Microservice.productService.model.ProductListDTO;
import com.Microservice.productService.model.ProductRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController implements ProductsApiDelegate {

    private ProductService productService;
    private PriceService priceService;

    public ProductController(ProductService productService,PriceService priceService) {
        this.productService = productService;
        this.priceService = priceService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ProductsApiDelegate.super.getRequest();
    }

    /**
     * POST
     * @Operation: CREAR PRODUCTO
     * @Param: ProductRequestDTO
     * @Return: ProductDTO
     * */
    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductRequestDTO productRequestDTO) {
        ProductDTO response = this.productService.save(productRequestDTO);
        this.priceService.save(new PriceRequestDTO()
                .price(response.getPrice())
                .dateCreated(LocalDate.now())
                .product(new ProductDTO().id(response.getId())));

        System.out.println(response.getId());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * @Operation: ELIMINAR PRODUCTO POR ID
     * @Param: INTEGER
     * @Return: -
     * */
    @Override
    public ResponseEntity<Void> deleteById(Integer productId) {
        return ProductsApiDelegate.super.deleteById(productId);
    }

    /**
     * GET
     * @Operation: LISTAR TODOS LOS PRODUCTOS
     * @Param: -
     * @Return: ProductDTO List
     * */
    @Override
    public ResponseEntity<ProductListDTO> retrieveAllProduct() {
        ProductListDTO productListDTO= new ProductListDTO().items(this.productService.retrieveAll());

        return ResponseEntity.ok().body(productListDTO);
    }

    /**
     * GET
     * @Operation: BUSCAR POR ID
     * @Param: Integer
     * @Return: ProductDTO
     * */
    @Override
    public ResponseEntity<ProductDTO> retrieveById(Integer productId) {

        ProductDTO productDTO = this.productService.retrieveById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    /**
     * GET
     * @Operation: BUSCAR PRODUCTO POR NOMBRE
     * @Param: String
     * @Return: ProductDTO
     * */
    @Override
    public ResponseEntity<ProductDTO> retrieveByName(String productName) {
        return ProductsApiDelegate.super.retrieveByName(productName);
    }

    /**
     * POST
     * @Operation: MODIFICAR PRODUCTO
     * @Param: PRODUCTO DTO
     * @Return: ProductDTO (MODIFICADO)
     * */
    @Override
    public ResponseEntity<ProductDTO> updateProduct(ProductRequestDTO productRequestDTO) {
        return ProductsApiDelegate.super.updateProduct(productRequestDTO);
    }
}
