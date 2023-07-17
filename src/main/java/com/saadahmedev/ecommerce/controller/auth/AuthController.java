package com.saadahmedev.ecommerce.controller.auth;

import com.saadahmedev.ecommerce.dto.auth.LoginRequest;
import com.saadahmedev.ecommerce.dto.auth.SignUpRequest;
import com.saadahmedev.ecommerce.service.auth.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> createAccount(@RequestBody SignUpRequest signUpRequest) {
        return authService.createAccount(signUpRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        return authService.logout(request);
    }
}
