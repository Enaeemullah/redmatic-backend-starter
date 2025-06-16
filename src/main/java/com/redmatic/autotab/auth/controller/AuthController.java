package com.redmatic.autotab.auth.controller;

import com.redmatic.autotab.auth.dto.LoginRequest;
import com.redmatic.autotab.auth.dto.AuthResponse;
import com.redmatic.autotab.auth.service.AuthService;
import com.redmatic.autotab.constants.ApiURI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiURI.BASE_AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(ApiURI.LOGIN)
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping(ApiURI.REGISTER)
    public ResponseEntity<String> register(@RequestBody LoginRequest request) {
        authService.registerUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok("User registered successfully!");
    }
}
