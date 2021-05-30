package com.lwcx.servicebase.handler;

import com.baomidou.mybatisplus.extension.api.R;
import com.lwcx.common.response.ResultResponse;
import com.lwcx.servicebase.exception.GuliException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 陈翔
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 指定出现什么异常执行这个方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public ResultResponse error(Exception e) {
        e.printStackTrace();
        return ResultResponse.error().message("执行了全局异常处理..");
    }

    /**
     * 特定异常
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResultResponse error(ArithmeticException e) {
        e.printStackTrace();
        return ResultResponse.error().message("执行了ArithmeticException异常处理..");
    }


    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public ResultResponse error(GuliException e) {
        log.error(e.getMessage());
        e.printStackTrace();

        return ResultResponse.error().code(e.getCode()).message(e.getMsg());
    }
}
