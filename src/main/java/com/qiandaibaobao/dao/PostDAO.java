package com.qiandaibaobao.dao;

import com.qiandaibaobao.pojo.Comment;
import com.qiandaibaobao.pojo.Post;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chris.zhang on 16-6-23.
 */
public interface PostDAO {
    public void savePost(@Param("title") String title,
                         @Param("content") String content,
                         @Param("authorId") int authorId,
                         @Param("createTime") Date createTime);

    public List<Post> posts(@Param("authorId") int authorId);
}
