package com.zy.usercenteradmin.common;

import com.zy.usercenteradmin.enums.ResultCodeEnum;
import lombok.Data;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Data
public class R {
    private Boolean success;

    private Integer code;

    private String message;

    private Object data;

    // 构造器私有
    private R() {
    }

    /**
     * 通用返回成功
     *
     * @return
     */
    public static R ok() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * 通用返回失败，未知错误
     *
     * @return
     */
    public static R error() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    /**
     * 设置结果，形参为结果枚举
     *
     * @param result
     * @return
     */
    public static R setResult(ResultCodeEnum result) {
        R r = new R();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    /**
     * 自定义返回数据
     *
     * @param map
     * @return
     */
    public R data(Object data) {
        this.setData(data);
        return this;
    }

    /**
     * 自定义状态信息
     *
     * @param message
     * @return
     */
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义状态码
     *
     * @param code
     * @return
     */
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 自定义返回结果
     *
     * @param success
     * @return
     */
    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
}
