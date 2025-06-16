package com.redmatic.autotab.organization.controller;

import com.redmatic.autotab.organization.dto.OrganizationSignupRequest;
import com.redmatic.autotab.organization.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/signup")
    public ResponseEntity<String> signupWithAdmin(@Valid @RequestBody OrganizationSignupRequest request) {
        organizationService.signupWithAdmin(request);
        return ResponseEntity.ok("Organization and admin created successfully");
    }
}
