package com.redmatic.starterkit.auth.service;

import com.redmatic.starterkit.auth.dto.LoginRequest;
import com.redmatic.starterkit.auth.dto.AuthResponse;
import com.redmatic.starterkit.auth.entity.User;
import com.redmatic.starterkit.auth.exception.AuthException;
import com.redmatic.starterkit.auth.repository.UserRepository;
import com.redmatic.starterkit.core.exception.ApiCode;
import com.redmatic.starterkit.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse authenticate(LoginRequest request) {
        log.info("Authenticating user: {}", request.getUsername());
        // Spring Security auth
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Generate token
        String token = tokenProvider.generateToken(authentication.getName());

        return AuthResponse.builder()
                .username(authentication.getName())
                .token(token)
                .build();
    }

    public void registerUser(String username, String rawPassword) {
        if (userRepository.existsByUsername(username)) {
            throw new AuthException(ApiCode.USER_ALREADY_EXISTS);
        }

        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(rawPassword))
                .build();

        userRepository.save(user);
    }
}
