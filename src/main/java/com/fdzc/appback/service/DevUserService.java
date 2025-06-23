package com.fdzc.appback.service;

import com.fdzc.appback.entity.DevUser;
import com.fdzc.appback.mapper.DevUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevUserService {
    @Autowired
    DevUserMapper devUserMapper;


    public PageInfo getPage(DevUser devUser, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"id ASC");
        List<DevUser> list=devUserMapper.selectBy(devUser);
        return new PageInfo(list);
    }
}
