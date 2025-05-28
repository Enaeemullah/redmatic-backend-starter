package com.redmatic.starterkit.auth.exception;

import com.redmatic.starterkit.core.exception.ApiCode;
import com.redmatic.starterkit.core.exception.BaseException;

public class AuthException extends BaseException {
    public AuthException(ApiCode code) {
        super(code);
    }
}
