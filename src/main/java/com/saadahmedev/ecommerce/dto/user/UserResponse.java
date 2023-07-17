package com.saadahmedev.ecommerce.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private byte[] profilePicture;
    private String phone;
}
