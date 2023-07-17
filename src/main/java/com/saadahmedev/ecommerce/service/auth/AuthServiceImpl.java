package com.saadahmedev.ecommerce.service.auth;

import com.saadahmedev.ecommerce.dto.auth.LoginRequest;
import com.saadahmedev.ecommerce.dto.auth.LoginResponse;
import com.saadahmedev.ecommerce.dto.auth.SignUpRequest;
import com.saadahmedev.ecommerce.entity.TokenData;
import com.saadahmedev.ecommerce.entity.User;
import com.saadahmedev.ecommerce.repository.auth.AuthRepository;
import com.saadahmedev.ecommerce.repository.auth.TokenRepository;
import com.saadahmedev.ecommerce.service.jwt.UserDetailsServiceImpl;
import com.saadahmedev.ecommerce.util.JwtUtil;
import com.saadahmedev.ecommerce.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private ValidatorUtil validatorUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String jwt = null;

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
                    .password(passwordEncoder.encode(signUpRequest.getPassword())).build();

            authRepository.save(user);
        }

        return validationResult;
    }

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        ResponseEntity<?> validationResult = validatorUtil.isLoginRequestValid(loginRequest);

        if (validationResult.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

            jwt = jwtUtil.generateToken(userDetails);

            validationResult = new ResponseEntity<>(new LoginResponse(
                    true,
                    "Logged in successfully",
                    jwt
            ), HttpStatus.OK);

            //Save token to database;
            saveToken(new TokenData(loginRequest.getEmail(), jwt));
        }

        return validationResult;
    }

    @Override
    public void saveToken(TokenData tokenData) {
        tokenRepository.save(tokenData);
    }
}
