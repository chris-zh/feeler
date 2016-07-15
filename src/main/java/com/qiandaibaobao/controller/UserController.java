package com.qiandaibaobao.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.page.Page;
import com.qiandaibaobao.pojo.LoginForm;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.Utils;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
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
        Utils.forward(model, Page.test);
        return "test";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/test/t1")
    @ResponseBody
    public JsonObject userList(@RequestBody LoginForm form) {
//        System.out.println("hahaha");
//        System.out.println(form);
//        System.out.println(form.getUsername());
//        System.out.println(form.getPassword());
        Gson json = new Gson();
        JsonObject r = new JsonObject();
        r.addProperty("success", "true");
        r.addProperty("message", "成功!");
        r.addProperty("next", "/login");
        r.addProperty("message", "失败！");

        Map map = new HashMap<>();
        map.put("haha", "sdff");
        map.put("dfdf", "asdfsf");
        String a = json.toJson(map);
        return r;
    }
}

