package com.qiandaibaobao.controller;

import com.qiandaibaobao.bo.IPost;
import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.page.Page;
import com.qiandaibaobao.pojo.Post;
import com.qiandaibaobao.pojo.User;
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

//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    public String index(HttpSession session, Model model) {
//        Object u = session.getAttribute("user");
//        if (u!=null) {
//            User user = (User)u;
//            List<Post> posts = postbo.posts(user.getId());
//            model.addAttribute("posts", posts);
//            Utils.forward(model, Page.post);
//            return "main";
//        } else {
//            return "index";
//        }
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String loginView() {
        System.out.println("fuck!");
        return "/templates/login.html";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(HttpSession session, Model model) {

        Object u = session.getAttribute("user");
        if (u != null) {
            User user = (User) u;
            model.addAttribute("user", user);
            List<Post> posts = postbo.posts(user.getId());
            model.addAttribute("posts", posts);
            Utils.forward(model, Page.post);
            return "main";
        } else {
            model.addAttribute("message", "请重新登录！");
            return "index";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        User user = bo.user(userName, password);
        if (user == null) {
            model.addAttribute("message", "用户名或密码错误，请重试！");
            return "index";
        } else {
            model.addAttribute("user", user);
            session.setAttribute("user", user);
            List<Post> posts = postbo.posts(user.getId());
            model.addAttribute("posts", posts);
            Utils.forward(model, Page.post);
            return "main";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register(@RequestParam("username") String userName,
                           @RequestParam("password") String password,
                           Model model) {
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
            model.addAttribute("message", "用户名或密码不能为空！");
            return "index";
        }
        boolean success = bo.register(userName, password);
        if(success){
            model.addAttribute("message", "注册成功，请登陆！");
        }else{
            model.addAttribute("message", "用户名已存在，请重试！");
        }
        return "index";
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
        model.addAttribute("message", "已成功退出！");
        return "index";
    }
}
