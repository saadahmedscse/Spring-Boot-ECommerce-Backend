package com.saadahmedev.ecommerce.repository.product;

import com.saadahmedev.ecommerce.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
