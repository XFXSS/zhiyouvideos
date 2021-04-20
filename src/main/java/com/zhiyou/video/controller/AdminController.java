package com.zhiyou.video.controller;


import com.zhiyou.video.model.Admin;
import com.zhiyou.video.model.Video;
import com.zhiyou.video.service.AdminControllerService;

import com.zhiyou.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private AdminControllerService adminControllerService;

    /**
     * 跳转到后台登陆界面
     */
    @RequestMapping("jump")
    public String jump(){
        return "/admin/login";
    }

    /**
     * 跳转到后台登陆界面
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model,String loginName,String loginPwd) {
        System.out.println("loginName = " + loginName);
        Admin admin = adminControllerService.login(loginName,loginPwd);

        if (admin != null){
            System.out.println("查询到的用户: "+admin);
            model.addAttribute("admin",admin);

//            查询全部视频信息
            List<Video> videoList = videoService.findAll();
            model.addAttribute("videoList",videoList);
            return "redirect:/video/list.do";
        }
        model.addAttribute("msg","用户名或密码错误!");
        return "/admin/login";
    }




}
