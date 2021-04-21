package com.zhiyou.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhiyou.video.model.Course;
import com.zhiyou.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/course")
public class AdminCourseController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public String list(Model model){

        // 1.取出 jedis
        Jedis jedis = jedisPool.getResource();
        jedis.select(2);

        // 2. 从Jedis中取出数据
        String listStr = jedis.get("couese:list");
        List<Course> list = null;
        if (listStr == null || "".equals(listStr)){
            list = courseService.findAll();
            String s = JSONObject.toJSONString(list);
            // 存入缓存
            jedis.set("couese:list",s);
            System.out.println("redis中没有，就从数据库中查：couese:list: "+list);
        }else {
            list = JSONObject.parseObject(listStr, ArrayList.class);
            System.out.println("redis中有，从redis中查：couese:list: "+list);
        }

        model.addAttribute("results",list);
        return "/admin/course/index";
    }
}
