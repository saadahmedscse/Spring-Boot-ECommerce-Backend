package com.saadahmedev.ecommerce.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private boolean status;
    private String message;
    private String token;
}
