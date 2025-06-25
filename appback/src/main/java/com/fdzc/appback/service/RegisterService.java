package com.fdzc.appback.service;

import com.fdzc.appback.dto.LoginDto;
import com.fdzc.appback.dto.RegisterDto;
import com.fdzc.appback.entity.BackendUser;
import com.fdzc.appback.entity.DevUser;
import com.fdzc.appback.mapper.BackendUserMapper;
import com.fdzc.appback.mapper.DevUserMapper;
import com.fdzc.appback.utils.JwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterService {
    @Autowired
    BackendUserMapper backendUserMapper;

    @Autowired
    DevUserMapper devUserMapper;
    public void register(RegisterDto registerDto) {
        String userCode=registerDto.getUsercode();
        String userName=registerDto.getUsername();
        String password=registerDto.getPassword();
        String userType=registerDto.getUserType();
        if(userType.equals("admin")) {
            if(backendUserMapper.selectByUserCode(userCode)==null) {
                BackendUser backendUser=new BackendUser();
                backendUser.setUsercode(userCode);
                backendUser.setUsername(userName);
                backendUser.setCreationdate(new Date());
                backendUserMapper.insert(backendUser);
            }else{
                throw new RuntimeException("账户已注册");
            }

        }else if(userType.equals("dev")) {
            if(devUserMapper.selectByUserCode(userCode)==null) {
                DevUser devUser=new DevUser();
                devUser.setDevcode(userCode);
                devUser.setDevname(userName);
                devUser.setCreationdate(new Date());
                devUserMapper.insert(devUser);
            }else{
                throw new RuntimeException("账户已注册");
            }
        }else {
            throw new RuntimeException("非法操作");
        }
    }
}
