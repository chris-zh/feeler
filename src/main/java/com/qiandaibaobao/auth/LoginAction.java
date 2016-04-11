package com.qiandaibaobao.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/haha")
public class LoginAction {
	final private AuthService service;

	@Autowired
	public LoginAction(AuthService service) {
		this.service = service;
	}

	@RequestMapping("/fuck")
	public String login(HttpServletRequest request) {
		User user = service.login("1", "2");
		System.out.println(user);
		return "base";
	}

}
