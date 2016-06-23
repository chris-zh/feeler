package com.qiandaibaobao.pojo;

import java.util.Date;

/**
 * Created by chris.zhang on 16-6-23.
 */
public class Comment {
    private int id;
    private String content;
    private Date createTime;

    public int getId() {
        return id;
    }

    public Comment setId(int id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Comment setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getAuthorId() {
        return authorId;
    }

    public Comment setAuthorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    private int authorId;
}
