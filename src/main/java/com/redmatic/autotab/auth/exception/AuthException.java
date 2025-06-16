package com.redmatic.autotab.auth.exception;

import com.redmatic.autotab.constants.ApiCode;
import com.redmatic.autotab.core.exception.BaseException;

public class AuthException extends BaseException {
    public AuthException(ApiCode code) {
        super(code);
    }
}
