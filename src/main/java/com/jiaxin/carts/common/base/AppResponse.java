package com.jiaxin.carts.common.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiaxin.carts.exception.ErrorCode;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse {

    @JsonProperty("status_code")
    private ApiStatusCode statusCode;

    @JsonProperty("error_code")
    private ErrorCode errorCode;

    private String message;

    private Object data;

    private AppResponse() {

    }

    public static AppResponse buildSuccess(Object data, String message, ApiStatusCode statusCode) {
        AppResponse appResponse = new AppResponse();
        appResponse.data = data;
        appResponse.message = message;
        appResponse.statusCode = statusCode;
        return appResponse;
    }

    public static AppResponse buildSuccess(Object data, ApiStatusCode apiStatusCode) {
        return buildSuccess(data, null, apiStatusCode);
    }

    public static AppResponse buildSuccess(Object data) {
        return buildSuccess(data, null, null);
    }

    public static AppResponse buildFailed(Object data, String message, ErrorCode errorCode) {
        AppResponse appResponse = new AppResponse();
        appResponse.data = data;
        appResponse.message = message;
        appResponse.errorCode = errorCode;
        return appResponse;
    }



}
