package com.redmatic.starterkit.auth.controller;

import com.redmatic.starterkit.auth.dto.LoginRequest;
import com.redmatic.starterkit.auth.dto.AuthResponse;
import com.redmatic.starterkit.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import com.redmatic.starterkit.constants.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.BASE_AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(AppConstants.LOGIN)
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping(AppConstants.REGISTER)
    public ResponseEntity<String> register(@RequestBody LoginRequest request) {
        authService.registerUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User registered successfully!");
    }
}
