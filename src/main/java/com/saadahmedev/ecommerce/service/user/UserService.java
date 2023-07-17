package com.saadahmedev.ecommerce.service.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseEntity<?> getProfile(HttpServletRequest request);
}
