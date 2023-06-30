package com.lee.dao.role;

import com.lee.pojo.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/** 角色数据持久层接口
 * Created by baidou on 2020/7/29.
 */
public interface RoleDao {

    //获取角色列表
    public List<Role> getRoleList(Connection connection) throws SQLException;
}
