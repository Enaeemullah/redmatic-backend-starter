package com.redmatic.starterkit.auth.dto;
import lombok.Data;

@Data
public class PermissionRequest {
        String moduleName;
        String actionName;
        String keyName;
        String name;
        String description;
}

