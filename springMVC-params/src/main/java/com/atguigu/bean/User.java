package com.atguigu.bean;


/**
 * @author ccstart
 * @create 2022-04-26 16:15
 */

public class User {

    private Integer id;
    private String username;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
}
