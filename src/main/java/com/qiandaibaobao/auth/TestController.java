package com.qiandaibaobao.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class TestController {
	final private AuthService service;
	
	@Autowired
	public TestController(AuthService service) {
		this.service = service;
	}

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
    	response.setContentType("application/json;charset=UTF-8");//·ÀÖ¹Êý¾Ý´«µÝÂÒÂë
		System.out.println("request = " + request);
        System.out.println("service = " + service);
        return "test";
    }
}