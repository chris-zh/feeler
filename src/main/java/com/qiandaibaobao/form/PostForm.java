package com.qiandaibaobao.form;

/**
 * Created by Administrator on 2016/7/30 0030.
 */
public class PostForm {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public PostForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostForm setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.title, this.content);
    }
}
