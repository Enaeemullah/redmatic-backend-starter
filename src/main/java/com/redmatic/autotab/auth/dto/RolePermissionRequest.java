package com.redmatic.autotab.auth.dto;

import lombok.Data;
import java.util.Map;

@Data
public class RolePermissionRequest {
    private String roleName;
    private String moduleName;
    private Map<String, Boolean> actions;
}

