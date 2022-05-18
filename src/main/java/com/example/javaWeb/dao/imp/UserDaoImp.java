package com.example.javaWeb.dao.imp;

import com.example.javaWeb.dao.UserDao;
import com.example.javaWeb.entity.User;
import com.example.javaWeb.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/9:29
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class UserDaoImp implements UserDao {
    private JDBCUtils jdbcUtils = new JDBCUtils();
    private Connection connection;
    private PreparedStatement preparedStatement;

    //转换形式，将数组转换为字符串
    public static String toString(String[] object) {
        String res = "";
        for (int i = 0; i < object.length - 1; i++) {
            res += object[i];
            res += ',';
        }
        res += object[object.length - 1];
        return res;
    }

    public static String[] toArray(String object) {
        if(object==null || object.equals("")) {
            return null;
        }
        return object.split(",");
    }

    @Override
    public boolean add(User user) {
        connection = jdbcUtils.getConnection();
        String sql = "INSERT INTO  `user` set username=? , passwd=?, sex=?, hobby=?;";
        int res = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPasswd());
            preparedStatement.setString(3, user.getSex());
            String Hobby = toString(user.getHobby());
            preparedStatement.setString(4, Hobby);
            res = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        if (res != 0) return true;
        else return false;
    }

    @Override
    public boolean delete(Integer id) {
        connection = jdbcUtils.getConnection();
        String sql = "DELETE FROM `user` WHERE id=?;";
        int res = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, id.toString());
            res = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        if (res ==1) return true;
        else return false;
    }

    @Override
    public boolean update(User user) {
        connection = jdbcUtils.getConnection();
        String sql = "UPDATE `user` SET `username`=?, `passwd`=?, `sex`= ?, `hobby`=?, `online` = ?, `balance`=? WHERE id=?;";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPasswd());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, toString(user.getHobby()));
            preparedStatement.setString(5, user.getOnline().toString());
            preparedStatement.setString(6, user.getBalance().toString());
            preparedStatement.setString(7, user.getId().toString());
            //执行sql语句
            int res = preparedStatement.executeUpdate();
            if (res==1) {
                flag=true;
                System.out.println("updateUser Success");
            } else {
                System.out.println("updateUser False");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        return flag;
    }

    @Override
    public User getByName_Pwd(String username, String password) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from user where username=? and passwd=?";
        ResultSet resultSet = null;
        User user=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //将查询到的用户关键信息写进user中
                user=new User();
                user.setId(Integer.parseInt(resultSet.getString(1)));
                user.setName(resultSet.getString(2));
                user.setPasswd(resultSet.getString(3));
                user.setSex(resultSet.getString(4));
                user.setHobby(toArray(resultSet.getString(5)));
                user.setOnline(Integer.parseInt(resultSet.getString(6)));
                user.setBalance(Double.parseDouble(resultSet.getString(7)));
                //
                System.out.println("getUser Success");
            } else {
                System.out.println("getUser False");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return user;
    }

    @Override
    public User getById(String id) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from user where id=?";
        ResultSet resultSet = null;
        User user=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, id);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //将查询到的用户关键信息写进user中
                user=new User();
                user.setId(Integer.parseInt(resultSet.getString(1)));
                user.setName(resultSet.getString(2));
                user.setPasswd(resultSet.getString(3));
                user.setSex(resultSet.getString(4));
                user.setHobby(toArray(resultSet.getString(5)));
                user.setOnline(Integer.parseInt(resultSet.getString(6)));
                user.setBalance(Double.parseDouble(resultSet.getString(7)));
                //
                System.out.println("getUser Success");
            } else {
                System.out.println("getUser False");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return user;
    }
}
