package com.jiaxin.carts.handler;

import com.jiaxin.carts.common.base.AppResponse;
import com.jiaxin.carts.exception.AppException;
import com.jiaxin.carts.exception.IllegalRequestException;
import com.jiaxin.carts.exception.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalRequestException.class)
    public ResponseEntity<AppResponse> handleIllegalRequestException(IllegalRequestException ex) {
        AppResponse appResponse = AppResponse.buildFailed(ex.getErrorCode(), ex.getMessage());
        return new ResponseEntity<>(appResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<AppResponse> handleAppException() {
        AppResponse appResponse = AppResponse.buildFailed(ErrorCode.SYSTEM_FAILED, ErrorCode.SYSTEM_FAILED.getMessage());
        return new ResponseEntity<>(appResponse, HttpStatus.BAD_GATEWAY);
    }

}
