package com.zhiyou.video.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;

public class Speaker {

    private int id;
    private String speaker_name;
    private String speaker_job;
    private String speaker_head_url;
    private String speaker_desc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insert_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", speaker_name='" + speaker_name + '\'' +
                ", speaker_job='" + speaker_job + '\'' +
                ", speaker_head_url='" + speaker_head_url + '\'' +
                ", speaker_desc='" + speaker_desc + '\'' +
                ", insert_time=" + insert_time +
                ", update_time=" + update_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeaker_name() {
        return speaker_name;
    }

    public void setSpeaker_name(String speaker_name) {
        this.speaker_name = speaker_name;
    }

    public String getSpeaker_job() {
        return speaker_job;
    }

    public void setSpeaker_job(String speaker_job) {
        this.speaker_job = speaker_job;
    }

    public String getSpeaker_head_url() {
        return speaker_head_url;
    }

    public void setSpeaker_head_url(String speaker_head_url) {
        this.speaker_head_url = speaker_head_url;
    }

    public String getSpeaker_desc() {
        return speaker_desc;
    }

    public void setSpeaker_desc(String speaker_desc) {
        this.speaker_desc = speaker_desc;
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
}
