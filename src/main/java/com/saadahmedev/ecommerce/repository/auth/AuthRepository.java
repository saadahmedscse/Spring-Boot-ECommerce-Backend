package com.saadahmedev.ecommerce.repository.auth;

import com.saadahmedev.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Long> {
}
