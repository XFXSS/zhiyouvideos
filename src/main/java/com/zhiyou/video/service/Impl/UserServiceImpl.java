package com.zhiyou.video.service.Impl;

import com.zhiyou.video.mapper.UserMapper;
import com.zhiyou.video.model.User;
import com.zhiyou.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByLogin(String email, String password) {
        return userMapper.findUserByLogin(email,password);
    }

    @Override
    public void findUserByRegist(String email, String password) {
        userMapper.findUserByRegist(email,password);
    }
}
