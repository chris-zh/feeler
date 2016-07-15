package com.qiandaibaobao.pojo;

/**
 * Created by chris.zhang on 16-7-15.
 */
public class LoginForm {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginForm setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return String.format("{username: %s, password: %s}", this.username, this.password);
    }
}
