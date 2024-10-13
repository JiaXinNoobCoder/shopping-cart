package com.jiaxin.carts.exception;

public class IllegalRequestException extends AppException{
    public IllegalRequestException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public IllegalRequestException(int errorCode, String errorMessage, Throwable cause) {
        super(errorCode, errorMessage, cause);
    }
}
