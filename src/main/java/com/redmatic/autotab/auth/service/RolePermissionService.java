package com.redmatic.autotab.auth.service;

import com.redmatic.autotab.auth.dto.RolePermissionRequest;

public interface RolePermissionService {
    void assignPermissions(RolePermissionRequest request);
}
