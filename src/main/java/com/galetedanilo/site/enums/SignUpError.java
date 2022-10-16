package com.galetedanilo.site.enums;

import com.galetedanilo.site.interfaces.ApplicationError;

public enum SignUpError implements ApplicationError {
    EMAIL_ALREADY_EXISTS(191);

    private final Integer code;
    SignUpError(Integer code) {
        this.code = code;
    }

    @Override
    public String getErrorType() {
        return this.toString();
    }

    @Override
    public Integer getErrorCode() {
        return this.code;
    }
}
