package com.example.git123.entity;

import org.springframework.context.annotation.Configuration;

@Configuration
public class User {
    private String id;
    private String username;
    private String pwd;
    private String nickname;

    public User() {
    }

    public User(String id, String username, String pwd, String nickname) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.nickname = nickname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public String getNickname() {
        return nickname;
    }
}
