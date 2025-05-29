package com.redmatic.starterkit.constants;

public class ApiURI {
    public static final String API_BASE_PATH = "/api";
    public static final String BASE_AUTH = "/api/auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
    // Base Paths
    public static final String BASE_API_V1 = "/api/v1";
    public static final String ORG_SIGNUP = BASE_API_V1 + "/organizations/signup";
    public static final String POS_SALES = BASE_API_V1 + "/pos/sales";

    // Common HTTP Messages
    public static final String SUCCESS = "Success";
    public static final String FAILED = "Failed";

    private ApiURI() {
        // prevent instantiation
    }
}
