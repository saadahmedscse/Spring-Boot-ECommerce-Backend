package com.saadahmedev.ecommerce.dto.auth;

import lombok.Data;

@Data
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private byte[] profilePicture;
    private String phone;
}
