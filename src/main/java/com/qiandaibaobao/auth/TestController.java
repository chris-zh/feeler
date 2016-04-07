package com.qiandaibaobao.auth;

import java.util.Hashtable;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  //类似Struts的Action
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/fuck2")  // 请求url地址映射，类似Struts的action-mapping
    public String testLogin(HttpServletRequest request) {
        // @RequestParam是指请求url地址映射中必须含有的参数(除非属性required=false)
        // @RequestParam可简写为：@RequestParam("username")

//        if (!"admin".equals(username) || !"admin".equals(password)) {
//            return "loginError"; // 跳转页面路径（默认为转发），该路径不需要包含spring-servlet配置文件中配置的前缀和后缀
//        }
    	LinkedHashMap map = new LinkedHashMap();
    	Hashtable table = new Hashtable();
    	
        return "test";
    }
    public static void main(String[] args) {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet.xml"));
		bf.getBean("myTestBean");
		System.out.println(bf.toString());
	}
}