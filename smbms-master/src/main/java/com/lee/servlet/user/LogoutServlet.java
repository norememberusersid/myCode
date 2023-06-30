package com.lee.servlet.user;

import com.lee.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销操作
 * Created by baidou on 2020/8/21.
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //移除用户的session
        request.getSession().removeAttribute(Constants.USER_SESSION);
        //重定向到登录页
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
