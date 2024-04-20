package com.example.productservice2.controller;

import com.example.productservice2.models.Product;
import com.example.productservice2.services.FakeStoreProductService;
import com.example.productservice2.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping("/products")
    public void createProducts(){

    }
    @GetMapping("/products")
    public void getAllProducts() {

    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        Product product=new Product();

       return productService.getSingleProduct(id);



    }
    public void deleteProduct(Long id) {

    }
}
