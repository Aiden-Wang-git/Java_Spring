package com.exchange.used.configure;

import java.util.HashMap;
import java.util.Map;

public class LayuiResult {
    private int code = 0;//0表示正确
    private String msg;//错误信息
    private Map<String, Object> data = new HashMap<>();//内容

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
