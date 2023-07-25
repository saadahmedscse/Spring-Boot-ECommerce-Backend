package com.saadahmedev.ecommerce.repository.product;

import com.saadahmedev.ecommerce.entity.product.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
