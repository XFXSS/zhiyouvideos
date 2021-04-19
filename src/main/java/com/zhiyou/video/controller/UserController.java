package com.zhiyou.video.controller;

import com.zhiyou.video.model.User;
import com.zhiyou.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/front/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String email,String password) {
        if (email != null && password != null) {
            User user = userService.findUserByLogin(email,password);
            if (user != null || "".equals(user)) {

                return "";
            }
        }
        return "";
    }

    @RequestMapping("/regist.do")
    public String regist(String email,String password,String pswAgain) {
        if (password.equals(pswAgain)) {
            if (password != null && email != null) {
                userService.findUserByRegist(email,password);
                return "forward:/WEB-INF/jsp/front/video/index.jsp";
            }
            return "forward:/WEB-INF/jsp/front/video/index.jsp";
        }
        return "forward:/WEB-INF/jsp/front/video/index.jsp";
    }
}
