package com.jiaxin.carts.common.base;

import com.jiaxin.carts.exception.enums.ErrorCode;
import com.jiaxin.carts.exception.IllegalRequestException;


public class AppChecker {
    public static void assertNotNull(Object object) {
        if (object == null) {
            throw new IllegalRequestException(ErrorCode.ILLEGAL_REQUEST,
                    ErrorCode.ILLEGAL_REQUEST.getMessage());
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 大于或等于0
     * */
    public static void assertPositive(int number) {
        if (number <= 0) {
            throw new IllegalRequestException(ErrorCode.ILLEGAL_REQUEST,
                    ErrorCode.ILLEGAL_REQUEST.getMessage());
        }
    }

}
