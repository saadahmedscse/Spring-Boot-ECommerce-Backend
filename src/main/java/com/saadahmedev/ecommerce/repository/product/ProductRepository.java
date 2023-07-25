package com.saadahmedev.ecommerce.repository.product;

import com.saadahmedev.ecommerce.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT i FROM Product i WHERE i.title LIKE %:searchText% OR i.description LIKE %:searchText%")
    List<Product> searchProductsByWords(String searchText);
}
