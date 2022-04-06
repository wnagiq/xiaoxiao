package com.lollipop.candy.common.controller;

import java.time.LocalDateTime;


public class BaseController {
	
	/**
	 * 返回成功
	 *
	 * @param v
	 * @param <V>
	 * @return
	 */
	protected <V> ApiResponseInfo<V> apiResponseSuccess() {
		ApiResponseInfo<V> result = new ApiResponseInfo<>();
		result.setCode(200);
		result.setMessage("操作成功！");
		result.setDate(LocalDateTime.now().toString());
		return result;
	}

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
