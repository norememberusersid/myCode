package com.lee.dao.user;

import com.lee.dao.BaseDao;

import com.lee.pojo.User;
import com.mysql.jdbc.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 角色数据持久层实现类
 * Created by baidou on 2020/7/25.
 */
public class UserDaoImpl implements UserDao {

    /**
     * 得到要登录的用户
     *
     * @param connection
     * @param userCode
     * @return user
     * @throws SQLException
     */
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=? and userPassword=?";
            Object[] params = {userCode, userPassword};

            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            //释放资源
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }


    /**
     * 根据用户ID修改密码
     *
     * @param connection
     * @param id
     * @param password
     * @return
     * @throws SQLException
     */
    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        PreparedStatement pstm = null;
        int code = 0;
        if (connection != null) {
            String sql = "update smbms_user set smbms_user.userPassword=? where id=? ";
            Object[] param = {password, id};
            code = BaseDao.execute(connection, pstm, sql, param);
            return code;
        }
        return code;
    }

    /**
     * 根据用户名或者角色查询用户总数(******************)
     *
     * @param connection
     * @param username
     * @param userRole
     * @return
     * @throws SQLException
     */
    public int getUserCount(Connection connection, String username, int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;

        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");  //查询所有用户
            List<Object> list = new ArrayList<Object>(); //存放我们的参数

            if (!StringUtils.isNullOrEmpty(username)) { //模糊查询用户
                sql.append(" and u.userName like ?");
                list.add("%" + username + "%");  //index:0
            }

            if (userRole > 0) { //用户角色
                sql.append(" and u.userRole = ?"); //index:1
                list.add(userRole);
            }

            //在数据库中分页使用    limit startIndex,pageSize; 总数

            //将list转换为数组
            Object[] prams = list.toArray();

            System.out.println("UserDaoImpl->getUserCount:" + sql.toString());//输出最后完整的sql语句

            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), prams);

            if (rs.next()) {
                count = rs.getInt("count"); //从结果集中获取数量
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return count;
    }

    /**
     * 根据条件查询用户列表
     *
     * @param connection
     * @param userName
     * @param userRole
     * @param currentPageNo
     * @param pageSize
     * @return userList
     * @throws Exception
     */
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%" + userName + "%");
            }
            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo - 1) * pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
            while (rs.next()) {
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userList;
    }

    /**
     * 通过id获取用户信息
     *
     * @param connection
     * @param id
     * @return user
     * @throws SQLException
     */
    public User getUserById(Connection connection, String id) throws SQLException {
        User user = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (connection != null) {
            String sql = "select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.id=? and u.userRole = r.id";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
                user.setUserRoleName(rs.getString("userRoleName"));
            }
            //释放资源
            BaseDao.closeResource(null, pstm, rs);
        }
        //System.out.println(user);
        return user;
    }

    /**
     * 添加用户
     *
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    public int add(Connection connection, User user) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into smbms_user (userCode,userName,userPassword," +
                    "userRole,gender,birthday,phone,address,creationDate,createdBy) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {user.getUserCode(), user.getUserName(), user.getUserPassword(),
                    user.getUserRole(), user.getGender(), user.getBirthday(),
                    user.getPhone(), user.getAddress(), user.getCreationDate(), user.getCreatedBy()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            //释放资源
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    //通过userCode获取User
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if (null != connection) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            //释放资源
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    /**
     * 修改用户信息
     * @param connection
     * @param user
     * @return
     * @throws Exception
     */
    public int modify(Connection connection, User user) throws Exception {
        // TODO Auto-generated method stub
        int flag = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "update smbms_user set userName=?,"+
                    "gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ? ";
            //通过数组方式向PreparedStatement预编译对象传参
            Object[] params = {user.getUserName(),user.getGender(),user.getBirthday(),
                    user.getPhone(),user.getAddress(),user.getUserRole(),user.getModifyBy(),
                    user.getModifyDate(),user.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            //释放资源
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    public int deleteUserById(Connection connection, Integer delId) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if(null != connection){
            String sql = "delete from smbms_user where id=?";
            //通过数组方式向PreparedStatement预编译对象传参
            Object[] params = {delId};
            flag = BaseDao.execute(connection, pstm, sql, params);
            //释放资源
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;

    }


}
