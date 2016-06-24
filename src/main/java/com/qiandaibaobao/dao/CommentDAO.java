package com.qiandaibaobao.dao;

import com.qiandaibaobao.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Date;

/**
 * Created by chris.zhang on 16-6-24.
 */
public interface CommentDAO {
    public Comment comment(@Param("id") int id);

    public List<Comment> comments(@Param("postId") int postId);

    public void saveComment(@Param("content") String content,
                            @Param("createTime") Date date,
                            @Param("authorId") int authorId,
                            @Param("postId") int postId);
}
