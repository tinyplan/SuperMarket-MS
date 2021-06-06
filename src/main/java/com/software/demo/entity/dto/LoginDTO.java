package com.software.demo.entity.dto;

/**
 * @author tinyplan
 * 2021/6/2
 * <p>
 * 登录表单
 */
public class LoginDTO {
    private String username;
    private String password;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
