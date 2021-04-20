package com.zhiyou.video.controller;

import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/list")
    public String list(Model model){

        List<Speaker> list = speakerService.findAll();
        System.out.println("查询到的讲师 ======================================:"+list);
        model.addAttribute("list",list);
        return "/admin/speaker/index";
    }
}
