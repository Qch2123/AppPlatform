package com.fdzc.appback.controller;

import com.fdzc.appback.dto.LoginDto;
import com.fdzc.appback.dto.RegisterDto;
import com.fdzc.appback.service.RegisterService;
import com.fdzc.appback.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public ResultVo register(@RequestBody RegisterDto registerDto) {
        registerService.register(registerDto);
        return ResultVo.success("注册成功", null);
    }
}
