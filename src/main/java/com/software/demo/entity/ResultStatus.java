package com.software.demo.entity;

/**
 * 状态码
 */
public enum ResultStatus {
    RES_SUCCESS(20000, "请求成功"),
    RES_FAIL(50000, "请求失败");

    private final int code;
    private final String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
