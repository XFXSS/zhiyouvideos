package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.AdminMapper;
import com.zhiyou.video.model.Admin;
import com.zhiyou.video.service.AdminControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminControllerServiceImpl implements AdminControllerService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String loginName, String loginPwd) {
        return adminMapper.login(loginName,loginPwd);
    }
}
