package com.redmatic.starterkit.constants;

import lombok.Getter;

@Getter
public enum ApiCode {

    // ✅ Common
    SUCCESS("S0000", "Success"),
    INTERNAL_ERROR("S0001", "Internal server error"),
    INVALID_REQUEST("S0002", "Invalid request"),

    // ✅ Auth
    INVALID_CREDENTIALS("A0001", "Invalid username or password"),
    USER_ALREADY_EXISTS("A0002", "User already exists"),
    MODULE_EXISTS("M1001", "Module already exists"),
    MODULE_NOT_FOUND("S1001", "Module not found"),
    ACTION_NOT_FOUND("S1002", "Action not found"),
    PERMISSION_EXISTS("S1003", "Permission already exists"),
    ROLE_NOT_FOUND("S1004", "Role not found"),

    // ✅ Organization
    ORG_CODE_EXISTS("ORG001", "Organization code already exists"),
    ACTION_EXISTS("ORG002", "Action already exists" ),
    ORGANIZATION_CREATED("ORG003", "Organization and admin created successfully"),

    USER_EMAIL_ALREADY_EXISTS("USR001", "Email already exists"),
    USER_PHONE_ALREADY_EXISTS("USR002", "Phone number already exists");

    private final String code;
    private final String message;

    ApiCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
