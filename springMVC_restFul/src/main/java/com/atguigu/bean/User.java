package com.atguigu.bean;

import java.time.Period;

/**
 * @author ccstart
 * @create 2022-04-27 10:45
 */
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private Integer age;
    private String sex;

    public User(Integer id, String name, String pwd, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
