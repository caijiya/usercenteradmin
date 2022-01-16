package com.zy.usercenteradmin.common;

import com.zy.usercenteradmin.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Getter
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
