package com.zhiyou.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * 主讲人管理
 */
@Controller
@RequestMapping("/speaker")
public class AdminSpeakerController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private SpeakerService speakerService;

    /**
     * 主讲人查询全部
     */
    @RequestMapping("/list")
    public String list(Model model){

        // 1.取出 jedis
        Jedis jedis = jedisPool.getResource();
        jedis.select(2);

        // 2. 从Jedis中取出数据
        String listStr = jedis.get("speaker:list");
        List<Speaker> list = null;
        if (listStr == null || "".equals(listStr)){
            // 查询数据据库
            list = speakerService.findAll();
            String s = JSONObject.toJSONString(list);
            // 存入redis缓存
            jedis.set("speaker:list",s);
            System.out.println("redis中没有，就从数据库中查：speaker:list: "+list);
        }else {
            list = JSONObject.parseObject(listStr, ArrayList.class);
            System.out.println("redis中有，从redis中查：speaker:list: "+list);
        }

        model.addAttribute("list",list);
        return "/admin/speaker/index";
    }

    /**
     * 添加主讲人
     */
    @RequestMapping("/add")
    public String insert(){
        return "";
    }

    /**
     * 删除主讲人
     */
    @RequestMapping("/delete")
    public String deleteById(Integer id){
        return "";
    }

    /**
     * 更新主讲人
     */
    @RequestMapping("/jumpEdit")
    public String updateById(Integer id,Model model){
        Speaker speaker = speakerService.findById(id);
        System.out.println("回显数据：AdminSpeakerController。updateById： speaker："+speaker);
        model.addAttribute("speaker",speaker);
        return "/admin/speaker/edit";
    }
}
