package com.redmatic.starterkit.organization.controller;

import com.redmatic.starterkit.organization.dto.OrganizationSignupRequest;
import com.redmatic.starterkit.organization.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/signup")
    public ResponseEntity<String> signupWithAdmin(@Valid @RequestBody OrganizationSignupRequest request) {
        organizationService.signupWithAdmin(request);
        return ResponseEntity.ok("Organization and admin created successfully");
    }
}
