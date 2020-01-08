package com.saibo.base;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BaseController {

    public static ResultData fail(String err) {
        if (StringUtils.isEmpty(err)) {
            err = ReturnCode.FAIL.getMsg();
        }

        return ResultData.error(ReturnCode.FAIL.getCode(), err);
    }

    public static ResultData success() {
        return ResultData.success();
    }

    public static ResultData success(String msg) {
        return ResultData.success(msg);
    }

    public static ResultData success(Object data, String msg) {
        return ResultData.success(msg, data);
    }

    public static ResultData success(Object data, int count) {
        return ResultData.success(data, count);
    }

    public static ResultData success(Object data) {
        return ResultData.success(data);
    }

}
