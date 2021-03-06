package com.zhiyou.video.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Video {

    private int id;
    private String video_title;
    private int speaker_id;
    private int course_id;
    private int video_length;
    private String video_image_url;
    private String video_url;
    private String video_descr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insert_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;
    private int video_play_times;

    // 讲师姓名
    private String speaker_name;
    // 课程名字
    private String course_name;

    public Video(int id, String video_title, int speaker_id, int course_id, int video_length, String video_image_url, String video_url, String video_descr, Date insert_time, Date update_time, int video_play_times, String speaker_name, String course_name) {
        this.id = id;
        this.video_title = video_title;
        this.speaker_id = speaker_id;
        this.course_id = course_id;
        this.video_length = video_length;
        this.video_image_url = video_image_url;
        this.video_url = video_url;
        this.video_descr = video_descr;
        this.insert_time = insert_time;
        this.update_time = update_time;
        this.video_play_times = video_play_times;
        this.speaker_name = speaker_name;
        this.course_name = course_name;
    }

    public Video() {
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", video_title='" + video_title + '\'' +
                ", speaker_id=" + speaker_id +
                ", course_id=" + course_id +
                ", video_length=" + video_length +
                ", video_image_url='" + video_image_url + '\'' +
                ", video_url='" + video_url + '\'' +
                ", video_descr='" + video_descr + '\'' +
                ", insert_time=" + insert_time +
                ", update_time=" + update_time +
                ", video_play_times=" + video_play_times +
                ", speaker_name='" + speaker_name + '\'' +
                ", course_name='" + course_name + '\'' +
                '}';
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getSpeaker_name() {
        return speaker_name;
    }

    public void setSpeaker_name(String speaker_name) {
        this.speaker_name = speaker_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public int getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(int speaker_id) {
        this.speaker_id = speaker_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getVideo_length() {
        return video_length;
    }

    public void setVideo_length(int video_length) {
        this.video_length = video_length >= 0 ? video_length : 0;
    }

    public String getVideo_image_url() {
        return video_image_url;
    }

    public void setVideo_image_url(String video_image_url) {
        this.video_image_url = video_image_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_descr() {
        return video_descr;
    }

    public void setVideo_descr(String video_descr) {
        this.video_descr = video_descr;
    }

    public Date getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getVideo_play_times() {
        return video_play_times;
    }

    public void setVideo_play_times(int video_play_times) {
        this.video_play_times = video_play_times;
    }
}
