package com.software.demo.entity.form;

/**
 * @author tinyplan
 * 2021/6/2
 * <p>
 * 登录表单
 */
public class LoginForm {
    private String username;
    private String password;

    public LoginForm() {
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
