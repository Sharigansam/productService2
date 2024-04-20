package com.example.productservice2.controller;

import com.example.productservice2.dtos.CreateProductRequestDto;
import com.example.productservice2.dtos.ErrorDto;
import com.example.productservice2.models.Product;
import com.example.productservice2.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProducts(@RequestBody  CreateProductRequestDto productRequestDto){
        return productService.createProduct(
                productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getCategory(),
                productRequestDto.getImage()
        );

    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> reponseData= productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity= new ResponseEntity<>(reponseData, HttpStatusCode.valueOf(202));
        return responseEntity;
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        Product product=new Product();

       return productService.getSingleProduct(id);



    }
    public void deleteProduct(Long id) {

    }
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDto> handleNullPointerException(){
//        ErrorDto errorDto=new ErrorDto();
//        errorDto.setMessage("Something went wrong");
//        return new ResponseEntity<>(errorDto,
//                        HttpStatusCode.valueOf(404));


   // }
}
