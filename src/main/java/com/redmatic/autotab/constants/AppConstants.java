package com.redmatic.autotab.constants;

public class AppConstants {
    // Security
    public static final String[] SWAGGER_WHITELIST = {
            "/api/v1/organization/signup",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/webjars/**",
            "/actuator/**",
            "/api/health"
    };

    // Default Roles
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    // Token
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    // Profiles
    public static final String PROFILE_DEV = "dev";
    public static final String PROFILE_TEST = "test";
    public static final String PROFILE_PROD = "prod";

    // Date format
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
}
