package com.lee.service.role;

import com.lee.dao.BaseDao;
import com.lee.dao.role.RoleDao;
import com.lee.dao.role.RoleDaoImpl;
import com.lee.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by baidou on 2020/7/29.
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    /**
     * 获取角色列表
     */
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            BaseDao.closeResource(connection, null, null);
        }
        return roleList;
    }

    @Test
    public void Test() {
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
        }
    }

}
