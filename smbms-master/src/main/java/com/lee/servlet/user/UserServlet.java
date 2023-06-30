package com.lee.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.lee.pojo.Role;
import com.lee.pojo.User;
import com.lee.service.role.RoleService;
import com.lee.service.role.RoleServiceImpl;
import com.lee.service.user.UserService;
import com.lee.service.user.UserServiceImpl;
import com.lee.util.Constants;
import com.lee.util.PageSupport;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Controller,实现servlet复用
 * Created by baidou on 2020/8/21.
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        //通通过路由调用对应的业务
        if (method.equals("savepwd") && method != null) {
            this.updatePwd(req, resp);
        } else if (method.equals("add") && method != null) {
            this.add(req, resp);
        } else if (method.equals("view") && method != null) {
            this.getUserById(req, resp, "userview.jsp");
        } else if (method.equals("ucexist") && method != null) {
            this.userCodeExist(req, resp);
        } else if (method.equals("getrolelist") && method != null) {
            this.getRoleList(req, resp);
        } else if (method.equals("pwdmodify") && method != null) {
            this.pwdModify(req, resp);
        } else if (method.equals("query") && method != null) {
            this.query(req, resp);
        } else if (method.equals("modify") && method != null) {
            this.getUserById(req, resp, "usermodify.jsp");
        } else if (method.equals("modifyexe") && method != null) {
            this.modify(req, resp);
        } else if (method != null && method.equals("deluser")) {
            this.delUser(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    /**
     * 获取角色列表
     *
     * @param req
     * @param resp
     */
    private void getRoleList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        //把roleList转换成json对象输出
        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();
        //JSONArray 阿里巴巴的JSON工具类, 转换格式
        printWriter.write(JSONArray.toJSONString(roleList));
        printWriter.flush(); //刷新
        printWriter.close(); //关闭

    }


    /**
     * @param req
     * @param resp
     */
    private void userCodeExist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //判断用户账号是否可用
        String userCode = req.getParameter("userCode");

        //通过map集合封装json数据
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (StringUtils.isNullOrEmpty(userCode)) {
            //userCode == null || userCode.equals("")
            resultMap.put("userCode", "exist");
        } else {
            UserService userService = new UserServiceImpl();
            User user = userService.selectUserCodeExist(userCode);
            if (null != user) {
                resultMap.put("userCode", "exist"); //存在
            } else {
                resultMap.put("userCode", "notexist"); //不存在
            }
        }

        //把resultMap转为json字符串以json的形式输出
        //配置上下文的输出类型
        resp.setContentType("application/json");
        //从response对象中获取往外输出的writer对象
        PrintWriter outPrintWriter = resp.getWriter();
        //把resultMap转为json字符串 输出
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();//刷新
        outPrintWriter.close();//关闭流
    }


    /**
     * 添加用户操作
     *
     * @param req
     * @param resp
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("UserServlet -- > add()");
        //接收前端的参数
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");

        User user = new User();
        //将数据封装到User对象中
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User) req.getSession().getAttribute(Constants.USER_SESSION)).getId());

        UserService userService = new UserServiceImpl();
        if (userService.add(user)) {  //添加成功调用query方法,否则停留在添加页面
            resp.sendRedirect(req.getContextPath() + "/jsp/user.do?method=query");
        } else {
            req.getRequestDispatcher("useradd.jsp").forward(req, resp);
        }
    }

    /**
     * 修改用户操作
     *
     * @param request
     * @param response
     */
    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("UserServlet -- > modify()");
        String id = request.getParameter("uid");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        User user = new User();

        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());

        UserService userService = new UserServiceImpl();
        if (userService.modify(user)) { //如果修改成功重定向到展示页面，否则停留到此页
            response.sendRedirect(request.getContextPath() + "/jsp/user.do?method=query");
        } else {
            request.getRequestDispatcher("usermodify.jsp").forward(request, response);
        }

    }

    /**
     * 通过id获取用户信息
     *
     * @param req
     * @param resp
     * @param url
     */
    private void getUserById(HttpServletRequest req, HttpServletResponse resp, String url)
            throws ServletException, IOException {
        //获取前端参数
        String id = req.getParameter("uid");
        System.out.println("getUserById --> 获取的用户id为:" + id);
        if (!StringUtils.isNullOrEmpty(id)) { //id不为空的话,执行查询操作
            //调用后台方法得到user对象
            UserService userService = new UserServiceImpl();
            User user = userService.getUserById(id);
            System.out.println("getUserById --> 获取的用户信息为:" + user);
            req.setAttribute("user", user);
            //转发页面
            req.getRequestDispatcher(url).forward(req, resp);
        }

    }

    // 查询用户列表
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //从前端获取数据
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;

        //获取用户列表
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;

        //第一次走这个请求，一定是第一页，页面大小固定的
        int pageSize = 5;
        int currentPageNo = 1;


        if (queryUserName == null) {
            queryUserName = "";
        }
        if (temp != null && !temp.equals("")) {
            queryUserRole = Integer.parseInt(temp); //给查询赋值！ 0，1,2,3
        }
        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }

        //获取用户的总数 (分页： 上一页 ， 下一页，  )
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        //分页支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);//设置当前页码数
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPagelCount = ((int) (totalCount / pageSize)) + 1;

        // 控制首页和尾页
        if (totalPagelCount < 1) { //如果页面小于1,就显示第一页
            currentPageNo = 1;
        } else if (currentPageNo > totalPagelCount) { //如果大于最后一页，那么就等于最后一页
            currentPageNo = totalPagelCount;
        }

        //获取用户列表展示
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        req.setAttribute("userList", userList);

        // 获取角色列表
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();

        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalPageCount", totalPagelCount);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRole);

        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改密码
     *
     * @param req
     * @param resp
     */
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
        //从Session中取id
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        //获取前端参数
        String newpassword = req.getParameter("newpassword");
        boolean flag = false;

        if (o != null && newpassword != null && newpassword.length() != 0) {
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) o).getId(), newpassword);
            if (flag) {
                req.setAttribute("message", "修改密码成功，请退出，使用新密码登录!");
                //密码修改成功移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败");
            }
        } else {
            req.setAttribute("message", "新密码有问题");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证旧密码，session中有用户的密码
     */
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp) {
        //从session拿到用户
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        //获取前端参数
        String oldpassword = req.getParameter("oldpassword");

        //用Map装Ajax返回界面中的数据
        Map<String, String> resultMap = new HashMap<String, String>();
        if (o == null) { //Session过期了
            resultMap.put("result", "sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldpassword)) { //判断输入密码是否为空
            resultMap.put("result", "error");
        } else {
            String userPassword = ((User) o).getUserPassword(); //Session中的用户密码
            if (oldpassword.equals(userPassword)) { //校验接收的oldpassword是否与session中的密码一致
                resultMap.put("result", "true");
            } else {
                resultMap.put("result", "false");
            }
        }

        try {
            //设置响应消息格式为json
            req.setCharacterEncoding("utf-8");
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            //JSONArray 阿里巴巴的JSON工具类, 转换格式
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush(); //刷新
            writer.close(); //关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除用户
     *
     * @param request
     * @param response
     */
    private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取id
        String id = request.getParameter("uid");
        Integer delId = 0;
        try {
            delId = Integer.parseInt(id);
        } catch (Exception e) {
            delId = 0;
        }
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (delId <= 0) { //判断是否选中
            resultMap.put("delResult", "notexist");
        } else {
            UserService userService = new UserServiceImpl();
            if (userService.deleteUserById(delId)) {
                resultMap.put("delResult", "true");
            } else {
                resultMap.put("delResult", "false");
            }
        }

        //把resultMap转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();//刷新
        outPrintWriter.close();//关闭流
    }

}
