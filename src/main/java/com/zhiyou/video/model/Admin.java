package com.zhiyou.video.model;

public class Admin {

    private int id;
    private String login_name;
    private String login_pwd;

    @Override
    public String toString() {
        return "Admins{" +
                "id=" + id +
                ", login_name='" + login_name + '\'' +
                ", login_pwd='" + login_pwd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_pwd() {
        return login_pwd;
    }

    public void setLogin_pwd(String login_pwd) {
        this.login_pwd = login_pwd;
    }
}
