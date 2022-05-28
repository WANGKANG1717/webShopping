package com.example.javaWeb.dao.imp;

import com.example.javaWeb.dao.MessageDao;
import com.example.javaWeb.entity.Message;
import com.example.javaWeb.jdbcUtils.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/10:56
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class MessageDaoImp implements MessageDao {
    private JDBCUtils jdbcUtils = new JDBCUtils();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public Message getById(String id) {
        connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM `message` WHERE id= ?;";
        Message message=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            if (resultSet.next()) {
                message=new Message();
                message.setId(resultSet.getString(1));
                message.setuID(resultSet.getString(2));
                message.setmID(resultSet.getString(3));
                message.setContent(resultSet.getString(4));
                message.setPtime(LocalDateTime.parse(resultSet.getString(5), dateFormat));
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return message;
    }

    @Override
    public ArrayList<Message> getAll() {
        connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM `message`;";
        ArrayList<Message> messages = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (resultSet.next()) {
                Message message = new Message();
                message.setId(resultSet.getString(1));
                message.setuID(resultSet.getString(2));
                message.setmID(resultSet.getString(3));
                message.setContent(resultSet.getString(4));
                message.setPtime(LocalDateTime.parse(resultSet.getString(5), dateFormat));
                messages.add(message);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return messages;
    }

    @Override
    public boolean deleteById(String id) {
        System.out.println("Message -> deleteById");
        connection = jdbcUtils.getConnection();
        String sql = "DELETE FROM message WHERE id=?;";
        boolean flag=false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, id);
            if(preparedStatement.executeUpdate()==1) {
                flag=true;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return flag;
    }

    @Override
    public boolean add(String userID, String mID, String Content) {
        System.out.println("Message -> addByUserID_Content");
        connection = jdbcUtils.getConnection();
        String sql = "INSERT INTO  `message` set uID=?, mID=?, content=?;";
        boolean flag=false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, mID);
            preparedStatement.setString(3, Content);
            if(preparedStatement.executeUpdate()==1) {
                flag=true;
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return flag;
    }
}
