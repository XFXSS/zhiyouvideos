package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.CourseMapper;
import com.zhiyou.video.model.Course;
import com.zhiyou.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }
}
