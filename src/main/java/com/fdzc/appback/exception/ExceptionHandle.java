package com.fdzc.appback.exception;

import com.fdzc.appback.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo error(Exception e) {
        e.printStackTrace();
        return ResultVo.error(e.getMessage());
    }
}
