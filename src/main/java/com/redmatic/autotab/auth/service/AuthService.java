package com.redmatic.autotab.auth.service;

import com.redmatic.autotab.auth.dto.LoginRequest;
import com.redmatic.autotab.auth.dto.AuthResponse;
import com.redmatic.autotab.auth.entity.User;
import com.redmatic.autotab.auth.exception.AuthException;
import com.redmatic.autotab.auth.repository.UserRepository;
import com.redmatic.autotab.constants.ApiCode;
import com.redmatic.autotab.core.exception.BaseException;
import com.redmatic.autotab.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
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
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BaseException(ApiCode.INVALID_CREDENTIALS));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BaseException(ApiCode.INVALID_CREDENTIALS);
        }

        String token = tokenProvider.generateToken(user.getEmail());

        return new AuthResponse(token, user.getRole().getName(), user.getOrganization().getOrgaCode(), user.getFirstName(), user.getEmail());
    }

    public void registerUser(String username, String rawPassword) {
        if (userRepository.existsByEmail(username)) {
            throw new AuthException(ApiCode.USER_ALREADY_EXISTS);
        }

        User user = User.builder()
                .email(username)
                .password(passwordEncoder.encode(rawPassword))
                .build();

        userRepository.save(user);
    }
}
