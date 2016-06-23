package com.qiandaibaobao.controller;

import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chris.zhang on 2016/6/15 0015.
 */
@Controller
public class LoginController {
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    IUserBO bo;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(HttpSession session) {
        Object u = session.getAttribute("user");
        if (u!=null) {
            return "success";
        } else {
            return "index";
        }
    }
    @RequestMapping("/fuck/{fuckId}/fuck2")
    public String test(@PathVariable("fuckId") String fuckId){
        return null;
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
            return "success";
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
        bo.updateUser(userName, newPassword);
        model.addAttribute("message", "修改密码成功！");
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/change-password")
    public String changePasswordPage(HttpSession session, Model model) {
        Object u = session.getAttribute("user");
        if (u != null) {
            User user = (User)u;
            model.addAttribute("username", user.getName());
            return "changePassword";
        }else{
            model.addAttribute("message", "请登录！");
            return "index";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value="/logout")
    public String logout(HttpSession session, Model model,HttpServletRequest request){
        session.setAttribute("user", null);
        model.addAttribute("message", "已成功退出！");
        return "index";
    }
}
