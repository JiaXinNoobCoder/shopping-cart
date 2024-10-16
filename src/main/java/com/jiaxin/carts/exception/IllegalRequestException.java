package com.jiaxin.carts.exception;

import com.jiaxin.carts.exception.enums.ErrorCode;

public class IllegalRequestException extends AppException{
    public IllegalRequestException(ErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

}
