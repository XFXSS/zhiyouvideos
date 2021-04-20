package com.zhiyou.video.controller;

import com.zhiyou.video.model.Course;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.model.Video;
import com.zhiyou.video.service.CourseService;
import com.zhiyou.video.service.SpeakerService;
import com.zhiyou.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private CourseService courseService;

    /**
     * 跳转到视频管理界面
     */
    @RequestMapping("/list")
    public String list(Model model){
        List<Video> list = videoService.findAll();
        System.out.println("查询到的全部数据 VideoController.list :"+list);
        model.addAttribute("results",list);
        return "/admin/video/index";
    }

    /**
     * 编辑
     */
    @RequestMapping("/echo")
    public String echo(Model model,Integer id){

        Video video = videoService.findVideoById(id);
        System.out.println("VideoController.edit video :"+video);

        List<Speaker> speakers = speakerService.findAll();
        System.out.println("VideoController.edit speakers :"+speakers);

        List<Course> courses = courseService.findAll();
        System.out.println("VideoController.edit courses :"+courses);

        model.addAttribute("video",video);
        model.addAttribute("speakers",speakers);
        model.addAttribute("courses",courses);
        return "/admin/video/saveOrUpdate";
    }

    @RequestMapping("/edit")
    public String edit(Video video){
        System.out.println("video = " + video);
        videoService.updateOne(video);
        return "redirect:/video/list.do";
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping("/jump")
    public String jump(Model model){
        List<Speaker> speakers = speakerService.findAll();
        System.out.println("VideoController.edit speakers :"+speakers);

        List<Course> courses = courseService.findAll();
        System.out.println("VideoController.edit courses :"+courses);

        model.addAttribute("speakers",speakers);
        model.addAttribute("courses",courses);
        return "/admin/video/saveOrUpdate";
    }

    /**
     * 添加数据
     */
    public String insert(Model model){

//        List<Speaker> speakers = speakerService.findAll();
//        System.out.println("VideoController.edit speakers :"+speakers);
//
//        List<Course> courses = courseService.findAll();
//        System.out.println("VideoController.edit courses :"+courses);
//
//        model.addAttribute("speakers",speakers);
//        model.addAttribute("courses",courses);
        return "redirect:/video/list.do";
    }
}
