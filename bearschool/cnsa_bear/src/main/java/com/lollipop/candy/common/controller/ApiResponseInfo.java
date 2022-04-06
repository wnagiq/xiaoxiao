package com.lollipop.candy.common.controller;

import java.io.Serializable;

import lombok.Data;

/**
 * @description: API接口请求返回信息结构
 * @createDate: 2019/4/16
 */
@Data
public class ApiResponseInfo<V> implements Serializable {

    private static final long serialVersionUID = 9088856701997679580L;
	/**
	 * 返回数据内容
	 */
    private V value;
    /**
     * 返回接口信息
     */
    private String message;
    /**
     * 返回接口状态
     */
    private int code;
    /**
     * 返回接口时间
     */
    private String date;

    @Override
    public String toString() {
        return "ApiResponseInfo{" +
                "value=" + value +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", date='" + date + '\'' +
                '}';
    }
}
