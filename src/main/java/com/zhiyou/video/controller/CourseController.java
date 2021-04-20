package com.zhiyou.video.controller;

import com.zhiyou.video.model.Course;
import com.zhiyou.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Course> list = courseService.findAll();
        System.out.println("CourseController.list list = "+list);
        model.addAttribute("results",list);
        return "/admin/course/index";
    }
}
