package com.qiandaibaobao.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller  //����Struts��Action
public class LoginServlet {

    @RequestMapping("test/login.do")  // ����url��ַӳ�䣬����Struts��action-mapping
    public String testLogin(@RequestParam(value="username")String username, String password, HttpServletRequest request) {
        // @RequestParam��ָ����url��ַӳ���б��뺬�еĲ���(��������required=false)
        // @RequestParam�ɼ�дΪ��@RequestParam("username")

        if (!"admin".equals(username) || !"admin".equals(password)) {
            return "loginError"; // ��תҳ��·����Ĭ��Ϊת��������·������Ҫ����spring-servlet�����ļ������õ�ǰ׺�ͺ�׺
        }
        return "loginSuccess";
    }

    @RequestMapping("/test/login2.do")
    public ModelAndView testLogin2(String username, String password, int age){
        // request��response���ط�Ҫ�����ڷ����У�����ò��ϵĻ�����ȥ��
        // ��������������ҳ��ؼ���name��ƥ�䣬�������ͻ��Զ���ת��
        
        if (!"admin".equals(username) || !"admin".equals(password) || age < 5) {
            return new ModelAndView("loginError"); // �ֶ�ʵ����ModelAndView�����תҳ�棨ת������Ч����ͬ������ķ��������ַ���
        }
        return new ModelAndView(new RedirectView("../index.jsp"));  // �����ض���ʽ��תҳ��
        // �ض�����һ�ּ�д��
        // return new ModelAndView("redirect:../index.jsp");
    }
}