package com.example.javaWeb;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * 构造函数
     * 连接数据库
     */
    public JDBCUtils() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("database");
            driver = resource.getString("driver");
//            System.out.println(driver);
            Class.forName(driver);//记载数据库驱动，注册到驱动管理器
            url = resource.getString("url");
            username = resource.getString("username");
            password = resource.getString("password");
            System.out.println(username+":"+password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    获得连接对象的方法
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("数据库连接成功");
            } else {
                throw new Exception("数据库连接失败");
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close(Connection conn, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
