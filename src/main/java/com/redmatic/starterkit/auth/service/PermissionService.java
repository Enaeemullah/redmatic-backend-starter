package com.redmatic.starterkit.auth.service;

import com.redmatic.starterkit.auth.dto.PermissionRequest;

public interface PermissionService {
    void createPermission(PermissionRequest request);
}