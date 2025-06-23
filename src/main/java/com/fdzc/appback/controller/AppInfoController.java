package com.fdzc.appback.controller;

import com.fdzc.appback.entity.AppInfo;
import com.fdzc.appback.service.AppInfoService;
import com.fdzc.appback.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController

@RequestMapping("/appInfo")
public class AppInfoController {
    @Autowired
    AppInfoService appInfoService;

    @Value("D:/手游管理平台/logo/")
    String uploadPath;

    //审核
    @GetMapping("/examine")
    public ResultVo examine(Long appId,Integer opType) {
        try {
            appInfoService.examine(appId,opType);
            return ResultVo.success("",null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error("");
        }
    }

    //删除
    @DeleteMapping("/{id}")
    public ResultVo del(@PathVariable Long id) {
        appInfoService.del(id,uploadPath);
        return ResultVo.success("删除成功",null);
    }

    @GetMapping("/appWithVersion/{appId}")
    public ResultVo appWithVersion(@PathVariable Long appId) {
       AppInfo appInfo=appInfoService.getAppWithVersion(appId);
       return ResultVo.success("",appInfo);
    }

    @PostMapping("/upLogo/{id}")
    public ResultVo upLogo(@PathVariable Long id,MultipartFile logo) {

        if(logo!=null&&!logo.isEmpty()) {
            String originalFilename = logo.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            if(logo.getSize()>1024*1024) {
                return ResultVo.error("文件过大，请上传不要超过1M");
            }else if(
                    suffix.equalsIgnoreCase(".jpg")||
                    suffix.equalsIgnoreCase(".jpeg")||
                    suffix.equalsIgnoreCase(".gif")||
                    suffix.equalsIgnoreCase(".png")
            ) {
                    File savePath=new File(uploadPath);
                    if(!savePath.exists()) {
                        savePath.mkdirs();
                    }
                    String newName= UUID.randomUUID().toString().replace("-","");
                    File saveFile=new File(uploadPath+newName+suffix);
                    try {
                        logo.transferTo(saveFile);
                        AppInfo appInfo=appInfoService.getById(id);
                        appInfo.setLogopicpath(newName+suffix);
                        appInfoService.saveOrUpdate(appInfo);
                        return ResultVo.success("logo上传成功",null);
                    } catch (IOException e) {
                        throw new RuntimeException("文件上传异常");
                    }
                }else {
                    return ResultVo.error("文件格式不对，必须是图片");
                }
            }else {
                return ResultVo.error("文件必须上传");
            }
        }

    @GetMapping("/validateApkName")
    public ResultVo validateApkName(@RequestParam(required = true) String apkname,@RequestParam(required = false) Long id) {
      Boolean flag=appInfoService.validateApkName(apkname,id);
      return ResultVo.success(null,flag);
    }

    //上下架
    @PutMapping("/{appId}")
    public ResultVo upOrOff(@PathVariable Long appId) {
        AppInfo appInfo=appInfoService.getById(appId);
        if(appInfo.getStatus()==2L) {
            appInfo.setStatus(4L);
        }else if(appInfo.getStatus()==4L) {
            appInfo.setStatus(5L);
        }else if(appInfo.getStatus()==5L) {
            appInfo.setStatus(4L);
        }
        appInfoService.saveOrUpdate(appInfo);
        return ResultVo.success("",null);
    }

    //添加版本
    @PostMapping("/add")
    public ResultVo add(@RequestBody AppInfo appInfo) {
        appInfoService.saveOrUpdate(appInfo);
        return ResultVo.success("操作成功",null);
    }

    //分页条件查询
    @PostMapping("/page")
    public ResultVo page(@RequestBody AppInfo appInfo, @RequestParam(defaultValue = "1") Integer pageNum) {
        PageInfo pageInfo= appInfoService.getPage(appInfo,pageNum);
        return ResultVo.success("查询成功",pageInfo);
    }
}
