package com.qiandaibaobao.controller;

import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
@Controller
public class LoginController {
    @Autowired
    IUserBO bo;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register-init")
    public String registerInit() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        Model model,
                        HttpServletResponse response) {
        User user = bo.user(userName, password);
        System.out.println("Utils.utf8String(\"测试乱码\") = " + Utils.utf8String("测试乱码"));
        if (user == null) {
            model.addAttribute("message", Utils.utf8String("用户名或密码错误，请重试！"));
            return "index";
        } else {
            model.addAttribute("user", user);
            return "success";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register(@RequestParam("username") String userName,
                           @RequestParam("password") String password,
                           Model model) {
        boolean success = bo.register(new User(userName, password));
        if(success){
            model.addAttribute("message", Utils.utf8String("注册成功，请登陆！"));
            return "index";
        }else{
            model.addAttribute("message", Utils.utf8String("用户名已存在，请重试！"));
            return "register";
        }


    }
    @RequestMapping(method = RequestMethod.POST, value="/change-password-init")
    public String changePasswordInit(@RequestParam("username") String userName, Model model){
        model.addAttribute("username", userName);
        return "changePassword";
    }
    @RequestMapping(method = RequestMethod.POST, value="/change-password")
    public String changePassword(@RequestParam("username") String userName,
                                 @RequestParam("newPassword") String newPassword, Model model, HttpServletResponse response){
        boolean success = bo.changePassword(userName, null, newPassword);
        response.setCharacterEncoding("UTF-8");
        if(success){
            model.addAttribute("message", Utils.utf8String("修改密码成功！"));
            return "index";
        }else{
            model.addAttribute("message", Utils.utf8String("密码错误，请重试！"));
            model.addAttribute("username", userName);
            return "changePassword";
        }
    }
}
