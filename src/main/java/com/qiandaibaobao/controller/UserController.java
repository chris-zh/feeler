package com.qiandaibaobao.controller;

import com.qiandaibaobao.bo.IUserBO;
import com.qiandaibaobao.page.Page;
import com.qiandaibaobao.pojo.User;
import com.qiandaibaobao.util.Utils;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @RequestMapping(method = RequestMethod.GET, value="/user/{userId}/modify")
    public String modifyUserPage(@PathVariable("userId") int userId, Model model) {
        Utils.forward(model, Page.userProfileModify);
        return "main";
    }

    @RequestMapping(method = RequestMethod.POST, value="/user/{userId}/modify")
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
}
