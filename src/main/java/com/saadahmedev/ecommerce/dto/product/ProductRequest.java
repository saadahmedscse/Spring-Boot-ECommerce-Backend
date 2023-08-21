package com.saadahmedev.ecommerce.dto.product;

import jakarta.persistence.ElementCollection;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private int price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    @ElementCollection
    private List<String> images;
}
