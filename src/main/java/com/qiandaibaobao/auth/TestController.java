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
	
    @RequestMapping("/auth/login")  // ����url��ַӳ�䣬����Struts��action-mapping
    public String testLogin(HttpServletRequest request) {
        // @RequestParam��ָ����url��ַӳ���б��뺬�еĲ���(��������required=false)
        // @RequestParam�ɼ�дΪ��@RequestParam("username")

//        if (!"admin".equals(username) || !"admin".equals(password)) {
//            return "loginError"; // ��תҳ��·����Ĭ��Ϊת��������·������Ҫ����spring-servlet�����ļ������õ�ǰ׺�ͺ�׺
//        }
    	User user = service.login("1", "2");
    	System.out.println(user);
        return "base";
    }
    
    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
    	response.setContentType("application/json;charset=UTF-8");//��ֹ���ݴ�������
    	return "base";
    }
}