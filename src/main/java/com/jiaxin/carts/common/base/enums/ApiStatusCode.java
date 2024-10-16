package com.jiaxin.carts.common.base.enums;

public enum ApiStatusCode {
    // 成功响应码
    SUCCESS_200(200, "OK - 请求成功"),
    CREATED_201(201, "Created - 请求已成功，并因此创建了一个新的资源"),
    NO_CONTENT_204(204, "No Content - 请求已成功，但响应不包含实体的主体部分"),

    // 客户端错误响应码
    BAD_REQUEST_400(400, "Bad Request - 请求的格式不正确或请求中包含无效参数"),
    UNAUTHORIZED_401(401, "Unauthorized - 未进行身份验证或身份验证失败"),
    FORBIDDEN_403(403, "Forbidden - 服务器理解请求但拒绝执行它"),
    NOT_FOUND_404(404, "Not Found - 请求的资源（网页等）不存在"),
    METHOD_NOT_ALLOWED_405(405, "Method Not Allowed - 请求方法不被允许"),
    REQUEST_TIMEOUT_408(408, "Request Timeout - 请求超时"),
    CONFLICT_409(409, "Conflict - 请求与资源的当前状态冲突"),

    // 服务器错误响应码
    INTERNAL_SERVER_ERROR_500(500, "Internal Server Error - 服务器内部错误，无法完成请求"),
    SERVICE_UNAVAILABLE_503(503, "Service Unavailable - 服务器当前无法使用（由于超载或停机维护）");

    private final int code;

    private final String description;

    ApiStatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


}
