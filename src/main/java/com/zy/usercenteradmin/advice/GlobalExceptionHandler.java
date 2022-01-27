package com.zy.usercenteradmin.advice;

import com.zy.usercenteradmin.common.BaseException;
import com.zy.usercenteradmin.common.R;
import com.zy.usercenteradmin.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * -------- 自定义定异常处理方法 --------
     **/
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public R error(BaseException e) {
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());
    }

    /**
     * -------- 指定异常处理方法 --------
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R error(NullPointerException e) {
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.NULL_POINTER_EXCEPTION);
    }


    /**
     * -------- 通用异常处理方法 --------
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error();
    }

    /**
     * -------- 通用异常处理方法 --------
     **/
    @ExceptionHandler(Error.class)
    @ResponseBody
    public R error(Error e) {
        e.printStackTrace();
        return R.error();
    }


}
