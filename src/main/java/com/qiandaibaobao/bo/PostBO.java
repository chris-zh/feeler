package com.qiandaibaobao.bo;

import com.qiandaibaobao.dao.PostDAO;
import com.qiandaibaobao.pojo.Comment;
import com.qiandaibaobao.pojo.Post;
import com.qiandaibaobao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by chris.zhang on 16-6-23.
 */
@Component
public class PostBO implements IPost {
    @Autowired
    PostDAO dao;
    public void savePost(Post post) {
        dao.savePost(post.getTitle(),post.getContent(),post.getAuthorId(),post.getCreateTime());
    }

    /**
     * 获得一个新的post对象
     * @param title
     * @param content
     * @param authorId
     * @param createTime
     * @param comments
     * @return
     */
    @Override
    public Post newPost(String title, String content, int authorId, Date createTime, List<Comment> comments) {
        return new Post().setTitle(title)
                .setContent(content)
                .setAuthorId(authorId)
                .setCreateTime(createTime)
                .setComments(comments);
    }

    @Override
    public List<Post> posts(int authorId) {
        return dao.posts(authorId);
    }

    @Override
    public Post post(int postId) {
        return dao.post(postId);
    }

    @Override
    public void updatePost(Post post) {
        dao.updatePost(post.getTitle(), post.getContent(), post.getUpdateTime(), post.getId());
    }

}
