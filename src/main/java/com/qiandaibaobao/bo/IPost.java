package com.qiandaibaobao.bo;

import com.qiandaibaobao.pojo.Comment;
import com.qiandaibaobao.pojo.Post;
import com.qiandaibaobao.pojo.User;

import java.util.Date;
import java.util.List;

/**
 * Created by chris.zhang on 16-6-23.
 */
public interface IPost {
    public void savePost(Post post);

    public Post newPost(String title, String content, int author, Date createTime, List<Comment> comments);

    public List<Post> posts(int authorId);

    public Post post(int postId);
}
