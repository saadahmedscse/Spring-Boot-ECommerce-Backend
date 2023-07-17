package com.saadahmedev.ecommerce.service.user;

import com.saadahmedev.ecommerce.dto.common.ApiResponse;
import com.saadahmedev.ecommerce.dto.user.UserResponse;
import com.saadahmedev.ecommerce.entity.User;
import com.saadahmedev.ecommerce.repository.user.UserRepository;
import com.saadahmedev.ecommerce.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<?> getProfile(HttpServletRequest request) {
        String email = jwtUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            return new ResponseEntity<>(mapToUserResponse(user.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(new ApiResponse(false, "User not found"), HttpStatus.BAD_REQUEST);
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .profilePicture(user.getProfilePicture()).build();
    }
}
