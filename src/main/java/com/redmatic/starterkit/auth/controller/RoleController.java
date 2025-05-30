package com.redmatic.starterkit.auth.controller;

import com.redmatic.starterkit.auth.dto.CreateRoleRequest;
import com.redmatic.starterkit.auth.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody CreateRoleRequest request) {
        roleService.createRoleWithPermissions(request);
        return ResponseEntity.ok("Role created successfully with permissions");
    }
}

