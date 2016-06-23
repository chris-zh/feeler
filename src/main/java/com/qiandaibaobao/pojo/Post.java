package com.qiandaibaobao.pojo;

import com.qiandaibaobao.util.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chris.zhang on 16-6-23.
 */
public class Post {
    private int id;
    private String title;
    private String content;
    private Date createTime;
    private int authorId;
    private List<Comment> comments;

    public int getId() {
        return id;
    }

    public Post setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public String getStringCreateTime(){
            return Utils.df2.format(this.createTime);
    }

    public Post setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getAuthorId() {
        return authorId;
    }

    public Post setAuthorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Post setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    @Override
    public String toString() {
        return String.format("[post:%s %s %s %s %s]", this.id,
                this.title,
                this.content,
                this.authorId,
                this.createTime);
    }
}
