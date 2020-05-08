package com.wthink.tensquare_base.error;

import com.wthink.tensquare_common.entity.Result;
import com.wthink.tensquare_common.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/8 11:35
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,"系统异常，请联系管理员");
    }
}
