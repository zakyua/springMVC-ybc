package com.atguigu.pojo;

/**
 * @author ccstart
 * @create 2022-04-26 19:28
 */
public class User {

    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
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

    public User() {
    }
}
