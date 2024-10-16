package com.jiaxin.carts.common.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiaxin.carts.common.base.enums.ApiStatusCode;
import com.jiaxin.carts.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse {

    @JsonProperty("status_code")
    private ApiStatusCode statusCode;

    @JsonProperty("error_code")
    private ErrorCode errorCode;

    @JsonProperty("message")
    private String message;

    private Object data;

    private AppResponse() {

    }

    public static AppResponse buildSuccess(Object data, ApiStatusCode statusCode, String message) {
        AppResponse appResponse = new AppResponse();
        appResponse.data = data;
        appResponse.statusCode = statusCode;
        appResponse.message = message;
        return appResponse;
    }

    public static AppResponse buildSuccess(Object data, ApiStatusCode statusCode) {
        return buildSuccess(data, statusCode, null);
    }

    public static AppResponse buildSuccess(ApiStatusCode statusCode) {
        return buildSuccess(null, statusCode, null);
    }

    public static AppResponse buildFailed(Object data, ErrorCode errorCode, String message) {
        AppResponse appResponse = new AppResponse();
        appResponse.data = data;
        appResponse.errorCode = errorCode;
        appResponse.message = message;
        return appResponse;
    }

    public static AppResponse buildFailed(ErrorCode errorCode, String message) {
        return buildFailed(null, errorCode, message);
    }

}
