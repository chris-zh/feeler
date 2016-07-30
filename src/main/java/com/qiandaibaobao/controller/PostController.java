package com.qiandaibaobao.controller;

import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qiandaibaobao.bo.IPost;
import com.qiandaibaobao.form.PostForm;
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


    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    @ResponseBody
    public String articles(HttpSession session) {
        User user = Utils.sessionUser(session);
        JsonObject response = new JsonObject();
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        List<Post> articles = bo.posts(user.getId());
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
        System.out.println("article = " + article);
        data.addProperty("success", true);
        data.add("article", parse.parse(gson.toJson(article)));
        return gson.toJson(data);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/newArticle")
    public String newArticleView() {
        return "/templates/article.html";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/newArticle")
    public String newArticleViewPost() {
        return "/templates/article.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/publish")
    @ResponseBody
    public String publish(@RequestBody PostForm postForm, HttpSession session) {
        System.out.println("postForm = " + postForm);
        User user = User.getSessionUser(session);
        Gson gson = new Gson();
        JsonObject response = new JsonObject();
        if (Utils.isNotNull(user)) {
            Post post = bo.newPost(postForm.getTitle(), postForm.getContent(), user.getId(), new Date(), null);
            bo.savePost(post);
            response.addProperty("success", true);
            response.addProperty("next", "/index");
        }else{
            response.addProperty("success", false);
            response.addProperty("next", "/login");
        }
        return gson.toJson(response);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateArticle/{postId}")
    @ResponseBody
    public String updateArticle(@RequestBody PostForm postForm,
                                @PathVariable String postId,
                                HttpSession session) {
        System.out.println("postId = " + postId);
        System.out.println("postForm = " + postForm);
        User user = User.getSessionUser(session);
        Gson gson = new Gson();
        JsonObject response = new JsonObject();
        if (Utils.isNotNull(user)) {
            Post post = new Post().setId(Integer.valueOf(postId))
                    .setTitle(postForm.getTitle())
                    .setContent(postForm.getContent())
                    .setUpdateTime(new Date());
            bo.updatePost(post);
            response.addProperty("success", true);
            response.addProperty("next", "/index");
        }else{
            response.addProperty("success", false);
            response.addProperty("next", "/login");
        }
        return gson.toJson(response);
    }
}
