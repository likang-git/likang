package com.saibo.model;

/**
 * layui通用数据返回类
 */
public class DataResult<T> {
    //layui所能是被的接口数据的返回成功标识
    public int code;
        //提示文本
    public String msg ;

    //结果的总记录数量
    public  int   count;

    public  T  data ;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
