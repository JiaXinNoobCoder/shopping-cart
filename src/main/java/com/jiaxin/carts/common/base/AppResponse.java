package com.jiaxin.carts.common.base;

import lombok.Data;

@Data
public class AppResponse {
    private int statusCode;

    private String message;

    private Object data;

    public AppResponse(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
