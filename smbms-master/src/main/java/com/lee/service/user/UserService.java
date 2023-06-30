package com.lee.service.user;

import com.lee.pojo.User;

import java.util.List;

/**
 * Created by baidou on 2020/8/21.
 */
public interface UserService {
    //用户登录
    public User login(String userCode,String password);

    //根据用户ID修改密码
    public boolean updatePwd(int id , String pwd);

    //查询记录数
    public int getUserCount(String username,int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);

    //根据ID查用户
    public User getUserById(String id);

    //添加用户
    public boolean add(User user);

    //根据userCode查询出User
    public User selectUserCodeExist(String userCode);

    //修改用户信息
    public boolean modify(User user);
    //删除用户
   public boolean deleteUserById(Integer delId);
}
