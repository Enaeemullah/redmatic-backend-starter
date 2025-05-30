package com.redmatic.starterkit.auth.controller;

import com.redmatic.starterkit.auth.dto.PermissionRequest;
import com.redmatic.starterkit.auth.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<String> createPermission(@RequestBody PermissionRequest request) {
        permissionService.createPermission(request);
        return ResponseEntity.ok("Permission created successfully");
    }
}
