package com.saadahmedev.ecommerce.service.product;

import com.saadahmedev.ecommerce.dto.product.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    ResponseEntity<?> createProduct(ProductRequest productRequest);

    ResponseEntity<?> getProducts();

    ResponseEntity<?> searchProducts(String searchText);
}
