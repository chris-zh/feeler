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
        String a = null;

        try {
            a.substring(10);
        } catch (Exception e) {
            logger.error(Utils.getStackTrace(e));
        }
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
        User user = bo.user(userName, Utils.encrypt(password));
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
        boolean success = bo.register(new User(userName, Utils.encrypt(password)));
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

    @RequestMapping(method = RequestMethod.POST, value="/logout")
    public String logout(HttpSession session, Model model,HttpServletRequest request){
        session.setAttribute("user", null);
        model.addAttribute("message", "已成功退出！");
        return "index";
    }
}
