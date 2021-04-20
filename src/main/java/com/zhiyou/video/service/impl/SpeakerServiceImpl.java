package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.SpeakerMapper;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerMapper speakerMapper;

    /**
     * 主讲人查询全部
     */
    @Override
    public List<Speaker> findAll() {
        return speakerMapper.findAll();
    }
}
