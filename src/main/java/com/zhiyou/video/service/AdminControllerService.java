package com.zhiyou.video.service;

import com.zhiyou.video.model.Admin;

public interface AdminControllerService {

    Admin login(String loginName, String loginPwd);
}
