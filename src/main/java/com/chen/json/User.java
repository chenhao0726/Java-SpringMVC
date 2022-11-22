package com.chen.json;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private Long id;
    private String name;
    private String password;
    private Integer gender;
    private Date time;

    public User() {
    }

    public User(String name, String password, Integer gender, Date time) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.time = time;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonFormat(pattern = "yyyy年MM月dd年 HH:mm:ss",timezone = "GMT+8")
    public Date getTime() {
        return time;
    }

    @DateTimeFormat(pattern = "yyyy年MM月dd年 HH:mm:ss")
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", time=" + time +
                '}';
    }
}
