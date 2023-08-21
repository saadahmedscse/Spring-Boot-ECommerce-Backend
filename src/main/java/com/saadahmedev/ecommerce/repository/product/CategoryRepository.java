package com.saadahmedev.ecommerce.repository.product;

import com.saadahmedev.ecommerce.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
