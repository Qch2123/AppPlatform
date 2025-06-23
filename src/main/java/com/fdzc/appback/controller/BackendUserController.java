package com.fdzc.appback.controller;


import com.fdzc.appback.dto.LoginDto;
import com.fdzc.appback.entity.AppInfo;
import com.fdzc.appback.entity.BackendUser;
import com.fdzc.appback.service.BackendUserService;
import com.fdzc.appback.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backendUser")
public class BackendUserController {
    @Autowired
    BackendUserService backendUserService;

    //分页带条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody BackendUser backendUser, @RequestParam(defaultValue = "1") Integer pageNum) {
        PageInfo pageInfo =backendUserService.getPage(backendUser,pageNum);
        return ResultVo.success("查询成功",pageInfo);
    }
}
