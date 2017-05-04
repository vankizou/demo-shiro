package com.zoufanqi.controller;

import com.zoufanqi.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    /*

    /user/login=anon
    /admin*=authc   <!--当有admin的URL请求就会 开始身份认证-->
    /student=roles[teacher]  <!--当有student的URL请求就会 开始  角色认证-->
    /teacher=perms["user:create"]<!--当有teacher的URL请求就会 开始权限认证-->

    */

    @ResponseBody
    @RequestMapping("/a")
    public String a() {
        Subject subject = SecurityUtils.getSubject();
        System.out.println("a, " + subject.getPrincipal());
        System.out.println("a, " + subject.isAuthenticated());
        System.out.println("a, " + subject.isRemembered());
        System.out.println("a, " + subject.isRunAs());
        return "a";
    }

    @ResponseBody
    @RequestMapping("/b")
    public String b() {
        Subject subject = SecurityUtils.getSubject();
        System.out.println("a, " + subject.getPrincipal());
        System.out.println("a, " + subject.isAuthenticated());
        System.out.println("a, " + subject.isRemembered());
        System.out.println("a, " + subject.isRunAs());
        return "b";
    }

    @ResponseBody
    @RequestMapping("/c")
    public String c() {
        Subject subject = SecurityUtils.getSubject();
        System.out.println("c, " + subject.getPrincipal());
        System.out.println("c, " + subject.isAuthenticated());
        System.out.println("c, " + subject.isRemembered());
        System.out.println("c, " + subject.isRunAs());
        return "c";
    }

    /**
     * 用户登录
     *
     * @param user
     * @param request
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();

        System.out.println(subject.isAuthenticated());
        System.out.println(subject.isRemembered());
        System.out.println("role1 ==== " + subject.hasRole("admin"));

        //Shiro获取用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        token.setRememberMe(true);
        try {
            //验证用户角色  
            subject.login(token);
            System.out.println("role2 ==== " + subject.hasRole("admin"));
            Session session = subject.getSession();
            System.out.println("sessionId:" + session.getId());
            System.out.println("sessionHost:" + session.getHost());
            System.out.println("sessionTimeout:" + session.getTimeout());
            session.setAttribute("info", "session的数据");
            return "redirect:/success.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "用户名或密码错误！");
            return "/index.jsp";
        }
    }
} 