package com.galetedanilo.site.exceptions;


import com.galetedanilo.site.enums.SignUpError;
import com.galetedanilo.site.interfaces.ApplicationException;

public class SignUpException extends RuntimeException implements ApplicationException {
    private static final long serialVersionUID = 1L;

    private final SignUpError errorCode;

    public SignUpException(String message, SignUpError errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public Integer getApplicationErrorCode() {
        return this.errorCode.getErrorCode();
    }

    @Override
    public String getApplicationErrorType() {
        return this.errorCode.getErrorType();
    }
}
