package com.saadahmedev.ecommerce.service.product;

import com.saadahmedev.ecommerce.dto.common.ApiResponse;
import com.saadahmedev.ecommerce.dto.product.CategoryRequest;
import com.saadahmedev.ecommerce.entity.category.Category;
import com.saadahmedev.ecommerce.repository.product.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> createMultipleCategories(List<CategoryRequest> categoryRequests) {
        List<Category> categories = new ArrayList<>();

        for (CategoryRequest categoryRequest : categoryRequests) {
            categories.add(Category.builder()
                    .categoryName(categoryRequest.getCategoryName())
                    .category(categoryRequest.getCategory())
                    .build());
        }

        categoryRepository.saveAll(categories);

        return new ResponseEntity<>(new ApiResponse(true, "Saved all categories"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
}
