package com.jiaxin.carts.exception;

import com.jiaxin.carts.exception.enums.ErrorCode;

public class AppException extends RuntimeException {
    private final ErrorCode errorCode;

    private final String errorMessage;

    public AppException(ErrorCode errorCode, String errorMessage) {

        super(errorMessage);

        this.errorCode = errorCode;

        this.errorMessage = errorMessage;

    }



    public AppException(ErrorCode errorCode, String errorMessage, Throwable cause) {

        super(errorMessage, cause);

        this.errorCode = errorCode;

        this.errorMessage = errorMessage;

    }

    public ErrorCode getErrorCode() {

        return errorCode;

    }

    @Override
    public String getMessage() {
        return errorMessage;

    }
}
