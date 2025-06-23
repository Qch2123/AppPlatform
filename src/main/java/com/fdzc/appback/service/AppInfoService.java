package com.fdzc.appback.service;

import com.fdzc.appback.entity.AppInfo;
import com.fdzc.appback.entity.AppVersion;
import com.fdzc.appback.mapper.AppInfoMapper;
import com.fdzc.appback.mapper.AppVersionMapper;
import com.fdzc.appback.mapper.DevUserMapper;
import com.fdzc.appback.utils.JwUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class AppInfoService {
    @Autowired
    AppInfoMapper appInfoMapper;

    @Autowired
    AppVersionMapper appVersionMapper;

    @Autowired
    DevUserMapper devUserMapper;

    @Autowired
    LoginService loginService;

    public PageInfo getPage(AppInfo appInfo, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"id desc");
        List<AppInfo> list=appInfoMapper.selectBy(appInfo);

        return new PageInfo(list);
    }

    public void saveOrUpdate(AppInfo appInfo) {
        if(appInfo.getId()==null) {//新增
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            String usercode = JwUtils.getUserCode(token);
            Long devId= devUserMapper.selectIdByUserCode(usercode);
            appInfo.setCreationdate(new Date());
            appInfo.setDownloads(0L);
            appInfo.setStatus(1L);
            appInfo.setDevid(devId);
            appInfo.setCreatedby(devId);
            appInfoMapper.insert(appInfo);
        }else {//修改
            appInfo.setModifydate(new Date());
            appInfoMapper.updateByPrimaryKeySelective(appInfo);
        }
    }

        public Boolean validateApkName(String apkname, Long id) {
        if(id!=null) {
            AppInfo appInfo1 = appInfoMapper.selectByPrimaryKey(id);
            if(appInfo1.getApkname().equals(apkname))
                return true;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.setApkname(apkname);
        List<AppInfo> list = appInfoMapper.selectBy(appInfo);
        if(list==null||list.size()==0) {
            return true;
        }else
            return false;
    }

    public AppInfo getById(Long id) {
        return appInfoMapper.selectByPrimaryKey(id);
    }

    public AppInfo getAppWithVersion(Long appid) {
        AppInfo appInfo = appInfoMapper.selectByPrimaryKey(appid);
        appInfo.setVersions(appVersionMapper.selectByAppId(appid));
        return appInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    public void del(Long id, String uploadPath) {
        List<AppVersion> appVersions = appVersionMapper.selectByAppId(id);
        for (AppVersion version : appVersions) {
            if(version.getDownloadlink()!=null) {
                File file=new File(uploadPath+version.getDownloadlink());
                if(file.exists()) {
                    file.delete();
                }
                appVersionMapper.deleteByPrimaryKey(version.getId());
            }
        }
        AppInfo appInfo = appInfoMapper.selectByPrimaryKey(id);
        if(appInfo.getLogopicpath()!=null) {
            File logo=new File(uploadPath+appInfo.getLogopicpath());
            logo.delete();
        }
        appInfoMapper.deleteByPrimaryKey(id);
    }

    public void examine(Long appId, Integer opType) {

        AppInfo appInfo = new AppInfo();
        appInfo.setId(appId);

        if(opType==1) {
            appInfo.setStatus(2L);
            appInfoMapper.update(appInfo);
        }else if(opType==2) {
            appInfo.setStatus(3L);
            appInfoMapper.update(appInfo);
        }else {
            throw new RuntimeException("操作不合法");
        }
    }
}
