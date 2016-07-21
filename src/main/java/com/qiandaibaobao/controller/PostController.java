package com.qiandaibaobao.controller;

import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qiandaibaobao.bo.IPost;
import com.qiandaibaobao.page.Page;
import com.qiandaibaobao.pojo.Post;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.JsonUtil;
import com.qiandaibaobao.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    @ResponseBody
    public String articles(HttpSession session) {
        User user = Utils.sessionUser(session);
        JsonObject response = new JsonObject();
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        List<Post> articles = bo.posts(10);
        response.addProperty("success", true);
        response.add("articles", parser.parse(gson.toJson(articles)));
        gson.toJson(response);
        return gson.toJson(response);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/article/{id}")
    @ResponseBody
    public String article(@PathVariable String id) {
        JsonObject data = new JsonObject();
        JsonParser parse = new JsonParser();
        Gson gson = new Gson();
        Post article = bo.post(Integer.valueOf(id));
        data.addProperty("success", true);
        data.add("article", parse.parse(gson.toJson(article)));
        return gson.toJson(data);
    }

}
