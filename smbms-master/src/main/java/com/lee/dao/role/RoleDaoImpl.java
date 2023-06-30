package com.lee.dao.role;

import com.lee.dao.BaseDao;
import com.lee.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidou on 2020/7/29.
 */
public class RoleDaoImpl implements RoleDao {

    /**
     * 获取角色列表
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        List<Role> roleList = new ArrayList<Role>();

        if (connection != null) {
            String sql = "select * from smbms_role";
            Object[] params = {};
            //返回结果集
            resultSet = BaseDao.execute(connection, pstm, resultSet, sql, params);

            while (resultSet.next()) {
                Role _role = new Role();
                _role.setId(resultSet.getInt("id"));
                _role.setRoleName(resultSet.getString("roleName"));
                _role.setRoleCode(resultSet.getString("roleCode"));
                roleList.add(_role);
            }
            System.out.println(roleList);
            //释放资源
            BaseDao.closeResource(null, pstm, resultSet);
        }
        return roleList;
    }
}
