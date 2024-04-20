package com.example.productservice2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {


    private String title;

    private String description;

    private double price;

    private String image;

    private String category;
}
