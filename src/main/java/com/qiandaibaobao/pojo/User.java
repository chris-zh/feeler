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
    public User(String name ,String password, String salt){
        this.name = name;
        this.password = password;
        this.salt = salt;
    }
    private int id;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String salt;

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
