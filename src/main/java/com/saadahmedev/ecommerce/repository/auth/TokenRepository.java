package com.saadahmedev.ecommerce.repository.auth;

import com.saadahmedev.ecommerce.entity.TokenData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenData, String> {
}
