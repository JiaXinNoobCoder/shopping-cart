package com.jiaxin.carts.common.base;

import com.jiaxin.carts.exception.ErrorCode;
import com.jiaxin.carts.exception.IllegalRequestException;


public class AppChecker {
    public static void assertNotNull(Object object) {
        if (object == null) {
            throw new IllegalRequestException(ErrorCode.ILLEGAL_REQUEST.getCode(),
                    ErrorCode.ILLEGAL_REQUEST.getMessage());
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }
}
