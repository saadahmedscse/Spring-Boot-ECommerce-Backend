package com.saadahmedev.ecommerce.util;

import com.saadahmedev.ecommerce.dto.auth.SignUpRequest;
import com.saadahmedev.ecommerce.dto.common.ApiResponse;
import com.saadahmedev.ecommerce.repository.auth.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidatorUtil {

    @Autowired
    private final AuthRepository authRepository;

    public ResponseEntity<?> isSignUpRequestValid(SignUpRequest req) {
        if (req.getFirstName() == null) {
            return createErrorResponse("First name is required");
        }

        if (req.getLastName() == null) {
            return createErrorResponse("Last name is required");
        }

        if (req.getEmail() == null) {
            return createErrorResponse("Email is required");
        }

        if (authRepository.findByEmail(req.getEmail()).isPresent()) {
            return createErrorResponse("Email already exist");
        }

        if (req.getPassword() == null) {
            return createErrorResponse("Password is required");
        }

        if (req.getConfirmPassword() == null) {
            return createErrorResponse("Confirm Password is required");
        }

        if (!req.getPassword().equals(req.getConfirmPassword())) {
            return createErrorResponse("Password didn't match");
        }

        return new ResponseEntity<>(new ApiResponse(true, "User registered successfully"), HttpStatus.CREATED);
    }

    private ResponseEntity<?> createErrorResponse(String message) {
        return new ResponseEntity<>(new ApiResponse(false, message), HttpStatus.BAD_REQUEST);
    }
}
