package com.qiandaibaobao.auth;

import com.qiandaibaobao.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/6/12 0012.
 */
@Controller
public class LoginCtrl {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@RequestParam(value = "username") String userName,
                        @RequestParam("password")String password,
                        Model model){
        if ("admin".equals(userName) && "admin".equals(password)) {
            model.addAttribute("userName", userName);
            return "success";
        }else{
            try {
                model.addAttribute("message", Utils.utf8String("登陆失败！用户名或密码错误！"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "index";
        }
    }
}
