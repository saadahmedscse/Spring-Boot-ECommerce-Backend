package com.saadahmedev.ecommerce.controller.product;

import com.saadahmedev.ecommerce.dto.product.ProductRequest;
import com.saadahmedev.ecommerce.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    public ResponseEntity<?> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProducts(@RequestParam("search") String searchText) {
        return productService.searchProducts(searchText);
    }
}
