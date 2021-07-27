package com.lollipop.star.common.controller;

import java.io.Serializable;

/**
 * @description: API接口请求返回信息结构
 * @createDate: 2019/4/16
 */
public class ApiResponseInfo<V> implements Serializable {

    private static final long serialVersionUID = 9088856701997679580L;

    private V value;
    private String message;
    private int code;
    private String date;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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
