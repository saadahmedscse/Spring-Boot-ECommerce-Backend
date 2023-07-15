package com.saadahmedev.ecommerce.service.auth;

import com.saadahmedev.ecommerce.dto.auth.LoginRequest;
import com.saadahmedev.ecommerce.dto.auth.SignUpRequest;
import com.saadahmedev.ecommerce.entity.TokenData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    ResponseEntity<?> createAccount(SignUpRequest signUpRequest);

    ResponseEntity<?> login(LoginRequest loginRequest);

    void saveToken(TokenData tokenData);
}
