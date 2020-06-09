package com.springboot.validator.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {


    private int id;

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度介于6到16之间")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
