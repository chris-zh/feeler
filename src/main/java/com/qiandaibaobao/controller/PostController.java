package com.qiandaibaobao.controller;

import java.util.Date;
import java.util.List;

import com.qiandaibaobao.bo.IPost;
import com.qiandaibaobao.page.Page;
import com.qiandaibaobao.pojo.Post;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by chris.zhang on 16-6-23.
 */
@Controller
public class PostController {
    @Autowired
    IPost bo;
    @RequestMapping(method = RequestMethod.POST, value = "/post")
    public String post(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpSession session,
            Model model) {
        User user = Utils.sessionUser(session);
        if (Utils.isNotNull(user)) {
            Post post = bo.newPost(title, content, user.getId(), new Date(), null);
            bo.savePost(post);
            model.addAttribute("message","发布成功！");
            List<Post> posts = bo.posts(user.getId());
            model.addAttribute("posts", posts);
            Utils.forward(model, Page.post);
            return "main";
        }else{
            model.addAttribute("message", "请先登录！");
            return "index";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/post")
    public String posts(HttpSession session, Model model) {
        User user = Utils.sessionUser(session);
        if (Utils.isNotNull(user)) {
            List<Post> posts = bo.posts(user.getId());
            model.addAttribute("posts", posts);
            model.addAttribute("user", user);
            Utils.forward(model, Page.post);
            return "main";
        }else{
            model.addAttribute("message", "请先登录！");
            return "index";
        }
    }
}
