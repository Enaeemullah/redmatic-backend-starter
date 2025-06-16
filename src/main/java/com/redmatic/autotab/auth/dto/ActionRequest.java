package com.redmatic.autotab.auth.dto;

import lombok.Data;

@Data
public class ActionRequest {
    private String name;           // e.g., "Manager"
    private String module;         // e.g., "Inventory"
    private String description;    // e.g., "Inventory Management"
    private boolean create;
    private boolean read;
    private boolean update;
    private boolean delete;
}
