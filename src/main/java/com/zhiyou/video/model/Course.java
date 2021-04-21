package com.zhiyou.video.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {

    private int id;
    private String course_name;
<<<<<<< HEAD
    private String course_descr;
=======
    private String course_desc;
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insert_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;
    private int subject_id;

<<<<<<< HEAD
    private String subject_name;

=======
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
<<<<<<< HEAD
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

=======
                ", course_desc='" + course_desc + '\'' +
                ", insert_time=" + insert_time +
                ", update_time=" + update_time +
                ", subject_id=" + subject_id +
                '}';
    }

>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
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

<<<<<<< HEAD
    public String getCourse_descr() {
        return course_descr;
    }

    public void setCourse_descr(String course_desc) {
        this.course_descr = course_desc;
=======
    public String getCourse_desc() {
        return course_desc;
    }

    public void setCourse_desc(String course_desc) {
        this.course_desc = course_desc;
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
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
