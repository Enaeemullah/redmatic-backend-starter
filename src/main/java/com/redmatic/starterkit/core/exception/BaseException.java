package com.redmatic.starterkit.core.exception;

public class BaseException extends RuntimeException {

    private final ApiCode code;

    public BaseException(ApiCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public ApiCode getCode() {
        return code;
    }
}
