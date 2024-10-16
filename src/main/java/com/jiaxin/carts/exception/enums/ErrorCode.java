package com.jiaxin.carts.exception.enums;

public enum ErrorCode {
    ILLEGAL_REQUEST(1001, "The request is illegal or invalid."),
    RESOURCE_NOT_FOUND(1002, "The requested resource was not found."),
    SYSTEM_FAILED(1003, "The System occurs an internal error."),
    UNAUTHORIZED(1004, "You are not authorized to perform this action.");
    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getFullMessage() {
        return "Error-" + code + ": " + message;
    }

}
