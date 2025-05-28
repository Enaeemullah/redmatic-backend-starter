package com.redmatic.starterkit.core.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getCode().getCode(),
                ex.getCode().getMessage()
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllUnhandledExceptions(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                ApiCode.INTERNAL_ERROR.getCode(),
                ApiCode.INTERNAL_ERROR.getMessage()
        );
        return ResponseEntity.internalServerError().body(error);
    }
}
