package com.zhiyou.video.service;

import com.zhiyou.video.model.User;

public interface UserService {


    User findUserByLogin(String email, String password);

    void findUserByRegist(String email, String password);
}
