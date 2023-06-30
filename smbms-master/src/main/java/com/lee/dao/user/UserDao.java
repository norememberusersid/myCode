package com.lee.dao.user;

import com.lee.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 对用户CRUD操作
 * Created by baidou on 2020/7/25.
 */
public interface UserDao {

    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException;

    //修改当前用户密码
    public int updatePwd(Connection connection, int id, String password) throws SQLException;

    //根据用户名或者角色查询用户总数
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException;

    //通过条件查询-userList
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

    //根据ID查用户
    public User getUserById(Connection connection, String id) throws SQLException;

    //添加用户
    public int add(Connection connection, User user) throws SQLException;

    //通过userCode获取User
    public User getLoginUser(Connection connection, String userCode) throws SQLException;

    //修改用户信息
    public int modify(Connection connection, User user) throws Exception;

    //通过id删除指定用户
    public int deleteUserById(Connection connection,Integer delId)throws Exception;

}
