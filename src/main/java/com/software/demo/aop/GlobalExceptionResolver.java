package com.software.demo.aop;

import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionResolver {
    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult<Object> handleException(Exception e){
        e.printStackTrace();
        return new ApiResult<>(ResultStatus.RES_FAIL, "出现未知的异常", null);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    @ResponseBody
    public ApiResult<Object> handleHttpMessageException(HttpMessageConversionException e) {
        return new ApiResult<>(ResultStatus.RES_FAIL, "数据无法注入", null);
    }

    /**
     * 数据校验异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ApiResult<Object> handleBindException(BindException e) {
        FieldError firstError = e.getFieldErrors().get(0);
        return new ApiResult<>(ResultStatus.RES_FAIL, firstError.getDefaultMessage(), firstError.getRejectedValue());
    }

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ApiResult<Object> handleException(BusinessException e){
        LOGGER.error(e.getMsg());
        return new ApiResult<>(e.getStatus(), e.getMsg(), null);
    }

}
