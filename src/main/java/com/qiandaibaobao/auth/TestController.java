package com.qiandaibaobao.auth;

import java.util.Hashtable;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  //����Struts��Action
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/fuck2")  // ����url��ַӳ�䣬����Struts��action-mapping
    public String testLogin(HttpServletRequest request) {
        // @RequestParam��ָ����url��ַӳ���б��뺬�еĲ���(��������required=false)
        // @RequestParam�ɼ�дΪ��@RequestParam("username")

//        if (!"admin".equals(username) || !"admin".equals(password)) {
//            return "loginError"; // ��תҳ��·����Ĭ��Ϊת��������·������Ҫ����spring-servlet�����ļ������õ�ǰ׺�ͺ�׺
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