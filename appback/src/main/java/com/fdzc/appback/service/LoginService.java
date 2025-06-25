package com.fdzc.appback.service;

import com.fdzc.appback.dto.LoginDto;
import com.fdzc.appback.entity.BackendUser;
import com.fdzc.appback.entity.DevUser;
import com.fdzc.appback.mapper.BackendUserMapper;
import com.fdzc.appback.mapper.DevUserMapper;
import com.fdzc.appback.utils.JwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    BackendUserMapper backendUserMapper;

    @Autowired
    DevUserMapper devUserMapper;

    public String login(LoginDto loginDto) {
        if(loginDto.getUserType().equals("admin")) {
            BackendUser admin=backendUserMapper.selectByUserCode(loginDto.getUsercode());
            if(admin==null) {
                throw new RuntimeException("该账号不存在");
            }
            if(!admin.getUserpassword().equals(loginDto.getPassword())) {
                throw new RuntimeException("密码错误");
            }
                String token = JwUtils.getToken(loginDto.getUsercode());
                return token;

        }else if(loginDto.getUserType().equals("dev")) {
            DevUser devUser=devUserMapper.selectByUserCode(loginDto.getUsercode());
            if(devUser==null) {
                throw new RuntimeException("该账号不存在");
            }
            if(!devUser.getDevpassword().equals(loginDto.getPassword())) {
                throw new RuntimeException("密码错误");
            }
                String token = JwUtils.getToken(loginDto.getUsercode());
                return token;

        }else {
            throw new RuntimeException("非法操作");
        }
    }
}


