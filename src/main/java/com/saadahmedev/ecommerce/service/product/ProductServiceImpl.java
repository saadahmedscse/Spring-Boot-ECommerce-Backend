package com.saadahmedev.ecommerce.service.product;

import com.saadahmedev.ecommerce.dto.common.ApiResponse;
import com.saadahmedev.ecommerce.dto.product.ProductRequest;
import com.saadahmedev.ecommerce.entity.product.Product;
import com.saadahmedev.ecommerce.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<?> createProduct(ProductRequest productRequest) {
        productRepository.save(
                Product.builder()
                        .title(productRequest.getTitle())
                        .description(productRequest.getDescription())
                        .price(productRequest.getPrice())
                        .discountPercentage(productRequest.getDiscountPercentage())
                        .rating(productRequest.getRating())
                        .stock(productRequest.getStock())
                        .brand(productRequest.getBrand())
                        .category(productRequest.getCategory())
                        .thumbnail(productRequest.getThumbnail())
                        .images(productRequest.getImages())
                        .build()
        );

        return new ResponseEntity<>(new ApiResponse(true, "Product added successfully"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> createMultipleProducts(List<ProductRequest> productRequests) {
        List<Product> products = new ArrayList<>();
        for (ProductRequest productRequest : productRequests) {
            products.add(Product.builder()
                    .title(productRequest.getTitle())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .discountPercentage(productRequest.getDiscountPercentage())
                    .rating(productRequest.getRating())
                    .stock(productRequest.getStock())
                    .brand(productRequest.getBrand())
                    .category(productRequest.getCategory())
                    .thumbnail(productRequest.getThumbnail())
                    .images(productRequest.getImages())
                    .build());
        }

        productRepository.saveAll(products);

        return new ResponseEntity<>(new ApiResponse(true, "All products added successfully"), HttpStatus.CREATED);
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
