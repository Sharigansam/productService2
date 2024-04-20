package com.example.productservice2.dtos;

import com.example.productservice2.models.Category;
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
}
