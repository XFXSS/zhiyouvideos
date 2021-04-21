package com.zhiyou.video.mapper;

import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.model.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    /**
     * 视频管理查全部
     */
    List<Video> findAll();

    /**
     * 查询并修改单个视频
     */
    Video findVideoById(Integer id);
    void updateOne(Video video);

    /**
     * 添加视频
     */
    void addOne(Video video);

    int deleteById(Integer id);
}
