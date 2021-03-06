package com.zhiyou.video.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {

    private int id;
    private String course_name;
    private String course_descr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insert_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;
    private int subject_id;

    private String subject_name;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", course_descr='" + course_descr + '\'' +
                ", insert_time=" + insert_time +
                ", update_time=" + update_time +
                ", subject_id=" + subject_id +
                ", subject_name='" + subject_name + '\'' +
                '}';
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_descr() {
        return course_descr;
    }

    public void setCourse_descr(String course_desc) {
        this.course_descr = course_desc;
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

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
}
