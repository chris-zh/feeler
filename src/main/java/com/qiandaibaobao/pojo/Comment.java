package com.qiandaibaobao.pojo;

import com.qiandaibaobao.util.Utils;

import java.util.Date;

/**
 * Created by chris.zhang on 16-6-23.
 * Comment: 评论
 */
public class Comment {
    private int id;
    private String content;
    private Date createTime;
    private int authorId;
    private int postId;

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

    public String getFormatCreateTime(){
        return Utils.df2.format(this.createTime);
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

    public int getPostId() {
        return postId;
    }

    public Comment setPostId(int postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public String toString() {
        return String.format("{Comment[id:%s,content:%s,createTime:%s,authorId:%s,postId:%s]}",
                this.id, this.content, this.getFormatCreateTime(), this.authorId, this.postId);
    }
}
