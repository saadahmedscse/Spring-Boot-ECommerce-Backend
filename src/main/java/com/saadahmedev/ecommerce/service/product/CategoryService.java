package com.saadahmedev.ecommerce.service.product;

import com.saadahmedev.ecommerce.dto.product.CategoryRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<?> createMultipleCategories(List<CategoryRequest> categoryRequests);

    ResponseEntity<?> getAllCategories();
}
