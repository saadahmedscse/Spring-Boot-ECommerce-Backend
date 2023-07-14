package com.saadahmedev.ecommerce.repository.auth;

import com.saadahmedev.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findFirstByEmail(String email);
}
