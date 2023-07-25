package com.saadahmedev.ecommerce.service.product;

import com.saadahmedev.ecommerce.dto.common.ApiResponse;
import com.saadahmedev.ecommerce.dto.product.ProductRequest;
import com.saadahmedev.ecommerce.entity.product.Product;
import com.saadahmedev.ecommerce.entity.product.Rating;
import com.saadahmedev.ecommerce.repository.product.ProductRepository;
import com.saadahmedev.ecommerce.repository.product.RatingRepository;
import com.saadahmedev.ecommerce.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public ResponseEntity<?> createProduct(ProductRequest productRequest) {
        Rating rating = Rating.builder()
                .rate(productRequest.getRating().getRate())
                .count(productRequest.getRating().getCount())
                .build();

        productRepository.save(
                Product.builder()
                        .title(productRequest.getTitle())
                        .category(productRequest.getCategory())
                        .description(productRequest.getDescription())
                        .price(productRequest.getPrice())
                        .image(productRequest.getImage())
                        .rating(ratingRepository.save(rating)).build()
        );

        return new ResponseEntity<>(new ApiResponse(true, "Product added successfully"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> searchProducts(String searchText) {
        return new ResponseEntity<>(productRepository.searchProductsByWords(searchText), HttpStatus.OK);
    }
}
