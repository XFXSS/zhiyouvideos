package com.zhiyou.video.service.Impl;

import com.zhiyou.video.mapper.VideoMapper;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.model.Video;
import com.zhiyou.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    /**
     * 视频管理查全部
     */
    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    /**
     * 编辑视频
     */
    @Override
    public Video findVideoById(Integer id) {
        return videoMapper.findVideoById(id);
    }
    /**
     * 更新
     */
    @Override
    public void updateOne(Video video) {
        videoMapper.updateOne(video);
    }

    /**
     * 添加视频数据
     */
    @Override
    public void addOne(Video video) {
        videoMapper.addOne(video);
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Integer id) {
        return videoMapper.deleteById(id);
    }

}
