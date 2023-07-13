package com.saadahmedev.ecommerce.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponse {
    private boolean status;
    private String message;
}
