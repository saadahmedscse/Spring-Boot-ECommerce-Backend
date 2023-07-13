package com.saadahmedev.ecommerce.service.auth;

import com.saadahmedev.ecommerce.dto.auth.SignUpRequest;
import com.saadahmedev.ecommerce.entity.User;
import com.saadahmedev.ecommerce.repository.auth.AuthRepository;
import com.saadahmedev.ecommerce.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private ValidatorUtil validatorUtil;

    @Override
    public ResponseEntity<?> createAccount(SignUpRequest signUpRequest) {
        ResponseEntity<?> validationResult = validatorUtil.isSignUpRequestValid(signUpRequest);

        if (validationResult.getStatusCode().isSameCodeAs(HttpStatus.CREATED)) {
            User user = User.builder()
                    .firstName(signUpRequest.getFirstName())
                    .lastName(signUpRequest.getLastName())
                    .email(signUpRequest.getEmail())
                    .phone(signUpRequest.getPhone())
                    .profilePicture(signUpRequest.getProfilePicture())
                    .password(signUpRequest.getPassword()).build();

            authRepository.save(user);
        }

        return validationResult;
    }
}
