package com.qiandaibaobao.controller;

import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by chris.zhang on 2016/6/15 0015.
 */
@Controller
public class LoginController {
    @Autowired
    IUserBO bo;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        Model model) {
        User user = bo.user(userName, password);
        if (user == null) {
            model.addAttribute("message", "用户名或密码错误，请重试！");
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
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
            model.addAttribute("message", "用户名或密码不能为空！");
            return "index";
        }
        boolean success = bo.register(new User(userName, password));
        if(success){
            model.addAttribute("message", "注册成功，请登陆！");
        }else{
            model.addAttribute("message", "用户名已存在，请重试！");
        }
        return "index";
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
            model.addAttribute("message", "修改密码成功！");
            return "index";
        }else{
            model.addAttribute("message", "密码错误，请重试！");
            model.addAttribute("username", userName);
            return "changePassword";
        }
    }
}
