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

    @Override
    public User findUserByprofile(String nick_name) {
        return userMapper.findUserByprofile(nick_name);
    }

    @Override
    public void findUserByprofiletwo(User user) {
        userMapper.findUserByprofiletwo(user);
    }

    @Override
    public User findUserByavatar(String nick_name) {
        return userMapper.findUserByavatar(nick_name);
    }

    @Override
    public void findUserByavatartwo(String head_url,String nick_name) {
        userMapper.findUserByavatartwo(head_url,nick_name);
    }

    @Override
    public User findUserBypassword(String nick_name) {
        return userMapper.findUserBypassword(nick_name);
    }

    @Override
    public void findUserBypasswords(String password, String newPasswords) {
        userMapper.findUserBypasswords(password, newPasswords);
    }
}
