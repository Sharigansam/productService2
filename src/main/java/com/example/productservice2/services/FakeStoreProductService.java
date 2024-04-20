package com.example.productservice2.services;

import com.example.productservice2.dtos.FakeStoreProductDto;
import com.example.productservice2.models.Category;
import com.example.productservice2.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private  RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id){

//        FakeStoreProductDto  fakeStoreProductDto =restTemplate
//                .getForObject(
//                        "https://fakestoreapi.com/products/"+id,
//                         FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+id,
                       FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();


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

    @Override
    public Product createProduct(String title, String description, Double price, String category, String image) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        FakeStoreProductDto response=restTemplate
                .postForObject("https://fakestoreapi.com/products",
                       fakeStoreProductDto,
                        FakeStoreProductDto.class);
        return response.toProduct();
    }
    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] response=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: response){
            products.add(fakeStoreProductDto.toProduct());
        }

        return products;

    }
}
