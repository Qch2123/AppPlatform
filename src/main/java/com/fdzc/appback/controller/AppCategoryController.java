package com.fdzc.appback.controller;

import com.fdzc.appback.entity.AppCategory;
import com.fdzc.appback.service.AppCategoryService;
import com.fdzc.appback.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appCategory")
public class AppCategoryController {

    @Autowired
    AppCategoryService appCategoryService;

    @GetMapping("/tree")
    public ResultVo getTree() {
        AppCategory tree=appCategoryService.getTree();
        return ResultVo.success("查询成功",tree);
    }
}
