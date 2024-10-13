package com.jiaxin.carts.exception;

public class AppException extends RuntimeException {
    private final int errorCode;

    private final String errorMessage;

    public AppException(int errorCode, String errorMessage) {

        super(errorMessage);

        this.errorCode = errorCode;

        this.errorMessage = errorMessage;

    }



    public AppException(int errorCode, String errorMessage, Throwable cause) {

        super(errorMessage, cause);

        this.errorCode = errorCode;

        this.errorMessage = errorMessage;

    }

    public int getErrorCode() {

        return errorCode;

    }

    @Override
    public String getMessage() {
        return errorMessage;

    }
}
