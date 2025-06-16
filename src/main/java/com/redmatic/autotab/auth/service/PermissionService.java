package com.redmatic.autotab.auth.service;

import com.redmatic.autotab.auth.dto.PermissionRequest;

public interface PermissionService {
    void createPermission(PermissionRequest request);
}