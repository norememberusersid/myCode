package com.lee.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的公共类
 * Created by baidou on 2020/7/24.
 */
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 静态代码块, 类加载的时候就初始化了
    static {
        Properties properties = new Properties();
        // 通过类加载器读取对应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    /**
     * 获取数据库的连接
     *
     * @return connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 加载驱动
            Class.forName(driver);
            // 获取数据库连接对象
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 编写查询公共类
     *
     * @param connection 数据库连接对象
     * @param sql        sql语句
     * @param params     sql语句中的参数
     * @return resultSet
     * @throws SQLException
     */
    public static ResultSet execute(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql, Object[] params) throws SQLException {
        // 预编译的sql, 在后面直接执行就可以了
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            // setObject占位符从1开始 , 数组索引从0开始
            preparedStatement.setObject(i + 1, params[i]);
        }
        //执行sql并返回结果集
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    /**
     * 编写增删改公共方法
     *
     * @param connection
     * @param sql
     * @param params
     * @param preparedStatement
     * @return
     * @throws SQLException
     */
    public static int execute(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            // setObject占位符从1开始 , 数组索引从0开始
            preparedStatement.setObject(i + 1, params[i]);
        }
        //执行sql并返回结果集
        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }

    /**
     * 释放资源
     */
    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;

        if (resultSet != null) {
            try {
                resultSet.close();
                // GC回收 (垃圾回收器)
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                // 表示没有释放成功
                flag = false;
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                // GC回收 (垃圾回收器)
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                // 表示没有释放成功
                flag = false;
            }
        }

        if (connection != null) {
            try {
                connection.close();
                // GC回收 (垃圾回收器)
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                // 表示没有释放成功
                flag = false;
            }
        }
        return flag;
    }

}
