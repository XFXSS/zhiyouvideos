package com.zhiyou.video.controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/video")
public class AdminVideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private JedisPool jedisPool;

    /**
     * 跳转到视频管理界面
     */
    @RequestMapping("/list")
    public String list(Model model){

//        // 1.从jedis中取出数据.
        Jedis jedis = jedisPool.getResource();
        jedis.select(2);
        String listStr = jedis.get("video:list");
        List<Video> list = null;
        if (listStr == null || "".equals(listStr)){
            // 查询mysql数据库
            list = videoService.findAll();
            String s = JSONObject.toJSONString(list);
            // 存入redis缓存
            jedis.set("video:list",s);
            System.out.println("redis中没有,mysql中查出数据: video:list: "+list);
        }else {
            list = JSONObject.parseObject(listStr, ArrayList.class);
            System.out.println("redis中查出数据: video:list: "+list );
        }
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

        Jedis jedis = jedisPool.getResource();
        jedis.del("video:list");

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
    @RequestMapping("/add")
    public String insert(Video video){
        System.out.println("1111111111111111111111111111111");
        videoService.addOne(video);

        Jedis jedis = jedisPool.getResource();
        jedis.del("video:list");

        return "redirect:/video/list.do";
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        int num = videoService.deleteById(id);

        Jedis jedis = jedisPool.getResource();
        jedis.del("video:list");

        return "{\"success\":true}";
    }
}
