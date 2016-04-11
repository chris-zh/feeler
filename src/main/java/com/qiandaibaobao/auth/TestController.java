package com.qiandaibaobao.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/2sfserf")
public class TestController {
	final private AuthService service;
	
	@Autowired
	public TestController(AuthService service) {
		this.service = service;
	}
	
    @RequestMapping("/auth/login")  // 请求url地址映射，类似Struts的action-mapping
    public String testLogin(HttpServletRequest request) {
        // @RequestParam是指请求url地址映射中必须含有的参数(除非属性required=false)
        // @RequestParam可简写为：@RequestParam("username")

//        if (!"admin".equals(username) || !"admin".equals(password)) {
//            return "loginError"; // 跳转页面路径（默认为转发），该路径不需要包含spring-servlet配置文件中配置的前缀和后缀
//        }
    	User user = service.login("1", "2");
    	System.out.println(user);
        return "base";
    }
    
    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
    	response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
    	return "base";
    }
}