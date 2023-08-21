package com.saadahmedev.ecommerce.controller.product;

import com.saadahmedev.ecommerce.dto.product.CategoryRequest;
import com.saadahmedev.ecommerce.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createMultipleCategories(@RequestBody List<CategoryRequest> categoryRequests) {
        return categoryService.createMultipleCategories(categoryRequests);
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
