package com.fdzc.appback.service;

import com.fdzc.appback.dto.LoginDto;
import com.fdzc.appback.entity.BackendUser;
import com.fdzc.appback.mapper.BackendUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackendUserService {
    @Autowired
    BackendUserMapper backendUserMapper;

    public PageInfo getPage(BackendUser backendUser, Integer pageNum) {
        PageHelper.startPage(pageNum,5,"id ASC");
        List<BackendUser> list=backendUserMapper.selectBy(backendUser);
        return new PageInfo(list);
    }

}
