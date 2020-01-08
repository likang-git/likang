package com.saibo.base;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

@Component
public class ResultData implements Serializable {
    protected int code;
    protected String msg;
    protected long count;
    protected Object data;

    public ResultData() {
    }

    public ResultData(int code, String msg, long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static ResultData success(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCode.SUCCESS.getCode());
        if (!StringUtils.isEmpty(msg)) {
            resultData.setMsg(msg);
        } else {
            resultData.setMsg(ReturnCode.SUCCESS.getMsg());
        }

        return resultData;
    }

    public static ResultData success(String msg, Object dataObject) {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCode.SUCCESS.getCode());
        if (!StringUtils.isEmpty(msg)) {
            resultData.setMsg(msg);
        } else {
            resultData.setMsg(ReturnCode.SUCCESS.getMsg());
        }

        resultData.setData(dataObject);
        if (dataObject instanceof List) {
            resultData.setCount((long)((List)dataObject).size());
        }

        return resultData;
    }

    public static ResultData success(Object list) {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCode.SUCCESS.getCode());
        resultData.setMsg(ReturnCode.SUCCESS.getMsg());
        resultData.setData(list);
        return resultData;
    }

    public static ResultData success(Object list, int total) {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnCode.SUCCESS.getCode());
        resultData.setMsg(ReturnCode.SUCCESS.getMsg());
        resultData.setData(list);
        resultData.setCount((long)total);
        return resultData;
    }

    public static ResultData success() {
        return success(ReturnCode.SUCCESS.getMsg());
    }

    public static ResultData error(int code, String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    public static ResultData error() {
        return error(ReturnCode.FAIL.getCode(), ReturnCode.FAIL.getMsg());
    }

    public static ResultData error(String msg) {
        return error(ReturnCode.FAIL.getCode(), msg);
    }

    public ResultData(List<?> list, int total) {
        this.data = list;
        this.count = (long)total;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
