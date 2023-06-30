package com.lee.service.user;

import com.lee.dao.BaseDao;
import com.lee.dao.user.UserDao;
import com.lee.dao.user.UserDaoImpl;
import com.lee.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 用户业务实现类
 * Created by baidou on 2020/8/21.
 */
public class UserServiceImpl implements UserService {

    //service层调dao层
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;
        connection = BaseDao.getConnection();
        try {
            //通过业务层调用对应的数据库操作
            user = userDao.getLoginUser(connection, userCode, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    /**
     * 根据用户ID修改密码
     *
     * @param id
     * @param pwd
     * @return
     * @throws SQLException
     */
    public boolean updatePwd(int id, String pwd) {
        System.out.println("updatePwd=>pwd:" + pwd);

        Connection connection = null;
        connection = BaseDao.getConnection();
        boolean flag = false;

        try {
            if (userDao.updatePwd(connection, id, pwd) > 0) { //判断是否修改成功
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    /**
     * 获取记录数
     *
     * @param username
     * @param userRole
     * @return
     */
    public int getUserCount(String username, int userRole) {
        Connection connection = null;
        int count = 0;

        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    /**
     * 根据条件查询用户列表
     *
     * @param queryUserName
     * @param queryUserRole
     * @param currentPageNo
     * @param pageSize
     * @return
     */
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName, queryUserRole, currentPageNo, pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }

    /**
     * 通过ID获取用户信息
     */
    public User getUserById(String id) {
        User user = null;
        Connection connection = null;
        try {
            //通过工具类获取数据库连接对象
            connection = BaseDao.getConnection();
            //通过id获取用户信息
            user = userDao.getUserById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
            user = null;
        } finally {
            //释放资源
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public boolean add(User user) {
        boolean flag = false;
        Connection connection = null;
        try {
            //获取数据库连接对象
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启jdbc事务管理
            int updateRows = userDao.add(connection, user);
            connection.commit();//提交
            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    /**
     * 通过UserCode校验用户是否存在
     *
     * @param userCode
     * @return
     */
    public User selectUserCodeExist(String userCode) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public boolean modify(User user) {
        Connection connection = null;
        boolean flag = false;
        try {
            //获取数据库连接对象
            connection = BaseDao.getConnection();
            if (userDao.modify(connection, user) > 0) //修改成功则返回true
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    /**
     * 删除用户
     */
    public boolean deleteUserById(Integer delId) {
        Connection connection = null;
        boolean flag = false;
        try {
            //获取数据库连接对象
            connection = BaseDao.getConnection();
            if (userDao.deleteUserById(connection,delId)>0)//修改成功则返回true
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }


    @Test
    public void test() {
        UserServiceImpl userService = new UserServiceImpl();
        int userCount = userService.getUserCount(null, 2);
        System.out.println(userCount);
    }
}
