package com.fdzc.appback.controller;

import com.fdzc.appback.entity.DevUser;
import com.fdzc.appback.service.DevUserService;
import com.fdzc.appback.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devUser")
public class DevUserController {
    @Autowired
    DevUserService devUserService;
    //分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody DevUser devUser,@RequestParam(defaultValue = "1") Integer pageNum) {
        PageInfo pageInfo =devUserService.getPage(devUser,pageNum);
        return ResultVo.success("查询成功",pageInfo);
    }
}
