package com.redmatic.starterkit.auth.service;

import com.redmatic.starterkit.auth.dto.RolePermissionRequest;

public interface RolePermissionService {
    void assignPermissions(RolePermissionRequest request);
}
