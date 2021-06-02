package com.software.demo.exception;

import com.software.demo.entity.ResultStatus;

/**
 * @author tinyplan
 * 2021/6/2
 * <p>
 * 通用业务异常
 */
public class BusinessException extends RuntimeException {

    private final int code;
    /**
     * 不使用message变量名
     * <p>
     * 若使用，则生成的getter方法名为getMessage(),
     * 而父类中同名方法返回的是detailMessage, 有歧义
     */
    private final String msg;
    private final ResultStatus status;

    public BusinessException(ResultStatus status) {
        // 使用默认的消息
        this(status, status.getMessage());
    }

    public BusinessException(ResultStatus status, String msg) {
        this.code = status.getCode();
        this.msg = msg;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ResultStatus getStatus() {
        return status;
    }

}
