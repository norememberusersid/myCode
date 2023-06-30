package com.lee.servlet.user;

import com.lee.pojo.User;
import com.lee.service.user.UserServiceImpl;
import com.lee.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录请求
 * Created by baidou on 2020/8/21.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet--start.....");
        //获取用户名和密码
        String userCode = request.getParameter("userCode");
        String userPassword = request.getParameter("userPassword");

        //和数据库中的密码进行比对,调用service;
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword); //已经把登录的人查出来了
        if (user!=null) { //查有此人, 可以登录
            //将用户的信息放到Session中
            request.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到主页
            response.sendRedirect("jsp/frame.jsp");
        }else { //查无此人,无法登陆
            //转发回登录界面 , 提示用户名或密码错误
            request.setAttribute("error","用户名或密码错误，请重新尝试亲!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}
