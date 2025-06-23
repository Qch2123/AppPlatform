package com.fdzc.appback.service;

import com.fdzc.appback.entity.AppVersion;
import com.fdzc.appback.mapper.AppVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionService {
    @Autowired
    AppVersionMapper appVersionMapper;
    public void save(AppVersion appVersion) {
        appVersionMapper.insert(appVersion);
    }
}
