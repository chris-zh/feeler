package com.qiandaibaobao.pojo;


import com.qiandaibaobao.page.FeelerConfig;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/13 0013.
 * User: 用户
 */
public class User {
    private int id;
    private String salt;
    private String name;
    private String password;
    private Date createTime;
    private List<Post> posts = new ArrayList<>();


    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public User setPosts(List<Post> posts) {
        this.posts = posts;
        return this;
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String salt) {
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User)){
            return false;
        }
        User u = (User)obj;
        return u.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return this.getId() + this.salt.length();
    }

    @Override
    public String toString() {
        return String.format("id:%s,name:%s,password:%s", id, name, password);
    }

    public static User getSessionUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return null;
        }else{
            return user;
        }
    }

}
