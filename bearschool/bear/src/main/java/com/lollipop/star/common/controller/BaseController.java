package com.lollipop.star.common.controller;

import java.time.LocalDateTime;

import com.lollipop.star.common.model.ResultModel;

public class BaseController {
    /**
     * 返回成功
     *
     * @param v
     * @param <V>
     * @return
     */
    protected <V> ApiResponseInfo<V> apiResponseSuccess(V v) {
        ApiResponseInfo<V> result = new ApiResponseInfo<>();
        result.setValue(v);
        result.setCode(200);
        result.setMessage("操作成功！");
        result.setDate(LocalDateTime.now().toString());
        return result;
    }
    
    /**
     * 返回成功
     *
     * @param v
     * @param resultMessage
     * @param <V>
     * @return
     */
    protected <V> ApiResponseInfo<V> apiResponseSuccess(V v, String resultMessage) {
        ApiResponseInfo<V> result = new ApiResponseInfo<>();
        result.setValue(v);
        result.setCode(200);
        result.setMessage(resultMessage);
        result.setDate(LocalDateTime.now().toString());
        return result;
    }

    protected <V> ApiResponseInfo<V> apiResponseFailed(ResultModel model) {
        return apiResponseFailed(model.isRes() ? 200 : 500, model.getMessage());
    }
    
    /**
     * 返回其他情况
     *
     * @param resultCode
     * @param resultMessage
     * @param <V>
     * @return
     */
    protected <V> ApiResponseInfo<V> apiResponseFailed(int resultCode, String resultMessage) {
        ApiResponseInfo<V> result = new ApiResponseInfo<>();
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setDate(LocalDateTime.now().toString());
        return result;
    }
}
