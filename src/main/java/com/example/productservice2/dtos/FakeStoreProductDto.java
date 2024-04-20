package com.example.productservice2.dtos;

import com.example.productservice2.models.Category;
import com.example.productservice2.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;

    private String title;

    private String description;

    private double price;

    private String image;

    private String category;
    public Product toProduct(){
        Product product=new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setImageUrl(getImage());
        Category category=new Category();
        category.setTitle(getCategory());
        product.setCategory(category);
        return product;

    }
}
