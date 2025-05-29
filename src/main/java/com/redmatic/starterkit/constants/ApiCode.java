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

    // ✅ Organization
    ORG_CODE_EXISTS("ORG001", "Organization code already exists");

    private final String code;
    private final String message;

    ApiCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
