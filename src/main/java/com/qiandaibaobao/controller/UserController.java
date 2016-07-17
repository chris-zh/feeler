package com.qiandaibaobao.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.page.Page;
import com.qiandaibaobao.form.LoginForm;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chris.zhang on 16-6-23.
 */
@Controller
public class UserController {
    @Autowired
    IUserBO bo;

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
    public String userProfile(@PathVariable("userId") int userId, Model model, HttpSession session) {
        User user = bo.user(userId);
        model.addAttribute("user", user);
        Utils.forward(model, Page.userProfile);
        return "main";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}/modify")
    public String modifyUserPage(@PathVariable("userId") int userId, Model model) {
        Utils.forward(model, Page.userProfileModify);
        return "main";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/{userId}/modify")
    public String modifyUser(@PathVariable("userId") int userId,
                             @RequestParam("avatar") String avatar, Model model,
                             HttpServletRequest request) {
        String projectPath = request.getSession().getServletContext().getRealPath("");
        bo.saveAvatar(userId, avatar, projectPath);
        System.out.println("avatar = " + avatar);
        User user = bo.user(userId);
        model.addAttribute("user", user);
        Utils.forward(model, Page.userProfile);
        return "main";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test(Model model) {
//        Utils.forward(model, Page.test);
        return "/templates/login.html";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/test/post")
    @ResponseBody
    public String  userList(@RequestBody LoginForm form) {
//        System.out.println("hahaha");
//        System.out.println(form);
//        System.out.println(form.getUsername());
//        System.out.println(form.getPassword());
        Gson json = new Gson();
        Map<String, Object> map = Maps.newHashMap();
        List<String> list = Lists.asList("数组", new String[]{"数组2", "数组3"});
        map.put("list", list);
        map.put("success", true);
        map.put("next", "/login");
        String a = json.toJson(map);
        return a;
    }
}

