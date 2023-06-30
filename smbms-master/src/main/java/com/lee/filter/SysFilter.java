package com.lee.filter;


import com.lee.pojo.User;
import com.lee.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统过滤器
 * Created by baidou on 2020/7/26.
 */
public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("SysFilter doFilter()===========");
        //获取request和response
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //过滤器，从Session中获取Session
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        if (user==null) { //已经被移除或者注销了,或者未登录
            response.sendRedirect("/error.jsp");
        }else{
            chain.doFilter(req,resp);
        }
    }

    public void destroy() {

    }
}
