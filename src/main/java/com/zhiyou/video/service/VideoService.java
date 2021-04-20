package com.zhiyou.video.service;

import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.model.Video;

import java.util.List;

public interface VideoService {

    List<Video> findAll();

    Video findVideoById(Integer id);

    void updateOne(Video video);
}
