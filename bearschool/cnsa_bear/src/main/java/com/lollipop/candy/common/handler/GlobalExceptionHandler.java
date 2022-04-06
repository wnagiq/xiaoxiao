package com.lollipop.candy.common.handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.apache.commons.lang.exception.ExceptionUtils;
//import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.lollipop.candy.common.controller.ApiResponseInfo;
import com.lollipop.candy.common.controller.BaseController;
import com.lollipop.candy.common.exception.BearException;
import com.lollipop.candy.common.exception.LimitAccessException;

import lombok.extern.slf4j.Slf4j;

/**
 * GlobalExceptionHandler
 * @author tianyin
 *
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends BaseController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseInfo handleException(Exception e) {
        log.error("系统内部异常，异常信息：", e);
        return apiResponseFailed(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

    @ExceptionHandler(value = BearException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseInfo handleParamsInvalidException(BearException e) {
        log.error(ExceptionUtils.getRootCauseMessage(e));
        return apiResponseFailed(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseInfo handleSqlException(SQLException e) {
        log.error(e.getMessage(), e);
        return apiResponseFailed(HttpStatus.INTERNAL_SERVER_ERROR.value(),"请检查sql语句");
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseInfo handleNullPointException(NullPointerException e) {
        log.error(ExceptionUtils.getFullStackTrace(e));
        return apiResponseFailed(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseInfo validExceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return apiResponseFailed(HttpStatus.BAD_REQUEST.value(),message.toString());
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return FebsResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseInfo handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), StringPool.DOT);
            message.append(pathArr[1]).append(violation.getMessage()).append(StringPool.COMMA);
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return apiResponseFailed(HttpStatus.BAD_REQUEST.value(),message.toString());
    }

    @ExceptionHandler(value = LimitAccessException.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public ApiResponseInfo handleLimitAccessException(LimitAccessException e) {
        log.warn(e.getMessage());
        return apiResponseFailed(HttpStatus.TOO_MANY_REQUESTS.value(),e.getMessage());
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponseInfo handleUnauthorizedException(Exception e) {
        log.error("权限不足，{}", e.getMessage());
        return apiResponseFailed(HttpStatus.FORBIDDEN.value(),e.getMessage());
    }
}
