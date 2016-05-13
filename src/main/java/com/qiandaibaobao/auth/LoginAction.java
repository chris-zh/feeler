package com.qiandaibaobao.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
		Map map = new HashMap();
		return "base";
	}

}
