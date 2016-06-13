package com.qiandaibaobao.auth;

import com.qiandaibaobao.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginCtrl {

    @Autowired
    AuthService service;

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
                        Model model) {

        User user = service.login(userName, password);
        if (user == null) {
            model.addAttribute("message", Utils.utf8String("登陆失败！用户名或密码错误！"));
            return "index";
        } else {
            model.addAttribute("user", user);
            return "success";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password, Model model) {
        service.register(username, password);
        model.addAttribute("message", Utils.utf8String("注册成功，请登录!"));
        return "index";
    }
}