package com.zhiyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/a")
public class LoginController {

    @RequestMapping("/b")
    @ResponseBody
    public String login() {
        return "";
    }
}
