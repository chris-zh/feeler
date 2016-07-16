package com.qiandaibaobao.form;

/**
 * Created by chris.zhang on 16-7-16.
 */
public class RegisterForm {
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public RegisterForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegisterForm setUsername(String username) {

        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterForm setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return String.format("{username: %s, password: %s}", this.username, this.password);
    }

}
