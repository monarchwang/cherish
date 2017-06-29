package com.monarchwang.website.utils;


public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("请求成功");
        result.setData(object);
        return result;
    }

    //没有参数调用（无数据，只需要提示请求是否成功）
    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
