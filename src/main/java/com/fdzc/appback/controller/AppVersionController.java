package com.fdzc.appback.controller;

import com.fdzc.appback.entity.AppInfo;
import com.fdzc.appback.entity.AppVersion;
import com.fdzc.appback.service.AppInfoService;
import com.fdzc.appback.service.AppVersionService;
import com.fdzc.appback.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/version")
public class AppVersionController {

    @Value("D:/手游管理平台/apk/")
    String uploadApkPath;

    @Autowired
    AppVersionService appVersionService;

    @Autowired
    AppInfoService appInfoService;

    //新增版本
    @PostMapping
    public ResultVo add(AppVersion appVersion, MultipartFile apkFile,HttpServletRequest request) {
        if(apkFile!=null&& !apkFile.isEmpty()) {
            String originalFilename = apkFile.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            if(apkFile.getSize()>1024*1024*500) {
                return ResultVo.error("文件过大，请上传不要超过500M");
            }else if(
                    suffix.equalsIgnoreCase(".apk")
            ) {
                File savePath=new File(uploadApkPath);
                if(!savePath.exists()) {
                    savePath.mkdirs();
                }
                String newName= UUID.randomUUID().toString().replace("-","");
                File saveFile=new File(uploadApkPath+newName+suffix);
                try {
                    apkFile.transferTo(saveFile);
                    // 修改为实际文件路径映射
                    appVersion.setDownloadlink("/apk/" + newName + suffix);
                    appVersion.setCreationdate(new Date());
                    appVersion.setPublishstatus(3L);

                    appVersionService.save(appVersion);
                    AppInfo appInfo=new AppInfo();
                    appInfo.setId(appVersion.getAppid());
                    appInfo.setVersionid(appVersion.getId());
                    appInfoService.saveOrUpdate(appInfo);
                    return ResultVo.success("添加成功",null);
                } catch (IOException e) {
                    throw new RuntimeException("文件上传异常");
                }
            }else {
                return ResultVo.error("文件格式不对，必须是apk文件");
            }
        }else {
            return ResultVo.error("apk文件必须上传");

        }
    }
}


