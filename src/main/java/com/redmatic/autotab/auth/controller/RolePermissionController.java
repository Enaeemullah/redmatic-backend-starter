package com.redmatic.autotab.auth.controller;

import com.redmatic.autotab.auth.dto.RolePermissionRequest;
import com.redmatic.autotab.auth.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RolePermissionController {

    private final RolePermissionService permissionService;

    @PostMapping("/assign-permissions")
    public ResponseEntity<String> assignPermissions(@RequestBody RolePermissionRequest request) {
        permissionService.assignPermissions(request);
        return ResponseEntity.ok("Permissions assigned successfully.");
    }
}
