package com.example.javaWeb.dao.imp;

import com.example.javaWeb.dao.NoticeDao;
import com.example.javaWeb.entity.Notice;
import com.example.javaWeb.entity. Notice;
import com.example.javaWeb.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/25/15:51
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class NoticeDaoImp implements NoticeDao {
    private JDBCUtils jdbcUtils = new JDBCUtils();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public Notice getById(String id) {
        connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM `notice` WHERE id= ?;";
        Notice notice=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                notice=new Notice();
                notice.setId(resultSet.getString(1));
                notice.setName(resultSet.getString(2));
                notice.setContent(resultSet.getString(3));
                notice.setPtime(resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return notice;
    }

    @Override
    public ArrayList<Notice> getAll() {
        connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM `notice`;";
        ArrayList<Notice> notices = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Notice notice = new Notice();
                notice.setId(resultSet.getString(1));
                notice.setName(resultSet.getString(2));
                notice.setContent(resultSet.getString(3));
                notice.setPtime(resultSet.getString(4));
                notices.add(notice);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return notices;
    }
}
