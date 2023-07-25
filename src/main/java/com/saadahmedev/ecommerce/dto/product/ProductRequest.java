package com.saadahmedev.ecommerce.dto.product;

import lombok.Data;

@Data
public class ProductRequest {
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
    private Rating rating;
}
