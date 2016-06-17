package com.qiandaibaobao.pojo;


/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class User {
    public User(){}
    public User(String name ,String password){
        this.name = name;
        this.password = password;
    }
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String password;

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

    @Override
    public String toString() {
        return String.format("id:%s,name:%s,password:%s", id, name, password);
    }
}
