package com.qiandaibaobao.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.qiandaibaobao.bo.IPost;
import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.form.LoginForm;
import com.qiandaibaobao.form.RegisterForm;
import com.qiandaibaobao.page.Page;
import com.qiandaibaobao.pojo.Post;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.JsonUtil;
import com.qiandaibaobao.util.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by chris.zhang on 2016/6/15 0015.
 */
@Controller
public class LoginController {
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    IUserBO bo;
    @Autowired
    IPost postbo;

    /**
     * 跳转页面
     * @param session
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String indexView(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/templates/login.html";
        }
        return "/templates/main.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String loginView() {
        return "/templates/login.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @ResponseBody
    public JsonObject register(@RequestBody RegisterForm form) {
            JsonObject r = new JsonObject();
        boolean success = bo.register(form.getUsername(), form.getPassword());
        if (success) {
            r.addProperty("success", true);
            r.addProperty("message", "注册成功，请登录");
            r.addProperty("next", "/login");
        } else {
            r.addProperty("next", "/");
            r.addProperty("success", false);
            r.addProperty("message", "用户名已存在");
        }
        return r;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "/templates/login.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public JsonObject login(@RequestBody LoginForm form, HttpSession session) {
        User user = bo.user(form.getUsername(), form.getPassword());
        JsonObject response = new JsonObject();
        if (user != null) {
            session.setAttribute("user", user);
            response.addProperty("success", true);
            response.addProperty("next", "/index");
        }else{
            response.addProperty("success", false);
            response.addProperty("next", "/login");
            response.addProperty("message", "用户名或密码错误");
        }
        return response;
    }


    @RequestMapping(method = RequestMethod.POST, value="/change-password")
    public String changePassword(@RequestParam("username") String userName,
                                 @RequestParam("newPassword") String newPassword, Model model, HttpServletResponse response){
        bo.changePassword(userName, newPassword);
        model.addAttribute("message", "修改密码成功！");
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/change-password")
    public String changePasswordPage(HttpSession session, Model model) {
        Object u = session.getAttribute("user");
        if (u != null) {
            User user = (User)u;
            model.addAttribute("username", user.getName());
            Utils.forward(model, Page.changePassword);
            return "main";
        }else{
            model.addAttribute("message", "请登录！");
            return "index";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/logout")
    public String logout(HttpSession session, Model model,HttpServletRequest request){
        session.setAttribute("user", null);
        return "/templates/login.html";
    }
}
