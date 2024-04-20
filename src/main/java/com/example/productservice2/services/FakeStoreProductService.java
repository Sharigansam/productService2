package com.example.productservice2.services;

import com.example.productservice2.dtos.FakeStoreProductDto;
import com.example.productservice2.models.Category;
import com.example.productservice2.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    private  RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id){

        FakeStoreProductDto  fakeStoreProductDto =restTemplate
                .getForObject(
                        "https://fakestoreapi.com/products/"+id,
                         FakeStoreProductDto.class);
        Product product=new Product();

            product.setId(fakeStoreProductDto.getId());


        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category=new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;


    }
}
