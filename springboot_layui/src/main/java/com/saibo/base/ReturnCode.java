package com.saibo.base;

public enum ReturnCode {
    FAIL(1, "操作失败"),
    SUCCESS(0, "操作成功");

    private int code;
    private String msg;

    private ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
