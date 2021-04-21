package com.zhiyou.video.service;

import com.zhiyou.video.model.User;

public interface UserService {


    User findUserByLogin(String email, String password);

    void findUserByRegist(String email, String password);

    User findUserByprofile(String nick_name);

    void findUserByprofiletwo(User user);

    User findUserByavatar(String nick_name);

    void findUserByavatartwo(String head_url,String nick_name);

    User findUserBypassword(String nick_name);

    void findUserBypasswords(String password, String newPasswords);
}
