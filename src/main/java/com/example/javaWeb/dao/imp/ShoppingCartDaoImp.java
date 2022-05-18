package com.example.javaWeb.dao.imp;

import com.example.javaWeb.dao.ShoppingCartDao;
import com.example.javaWeb.entity.Product;
import com.example.javaWeb.entity.ShoppingCart;
import com.example.javaWeb.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/11:17
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class ShoppingCartDaoImp implements ShoppingCartDao {
    private JDBCUtils jdbcUtils = new JDBCUtils();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ShoppingCartDaoImp() {
        super();
    }

    @Override
    public ArrayList<ShoppingCart> getByUserId(String userID) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from shoppingCart where userID=?;";
        ResultSet resultSet = null;
        ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, userID);
            //执行sql语句
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                ShoppingCart shoppingCart = new ShoppingCart(Integer.parseInt(userID));
                shoppingCart.setProductID(Integer.parseInt(resultSet.getString(2)));
                shoppingCart.setNum(Integer.parseInt(resultSet.getString(3)));
                shoppingCarts.add(shoppingCart);
            }
            if (shoppingCarts != null) {
                System.out.println("getByUserId Success");
            } else {
                System.out.println("getByUserId False");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return shoppingCarts;
    }

    @Override
    public ShoppingCart getByUserId_ProId(String userID, String productID) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from shoppingCart where userID=? && productID=?;";
        ResultSet resultSet = null;
        ShoppingCart shoppingCart = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, productID);
            //执行sql语句
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                shoppingCart = new ShoppingCart(Integer.parseInt(userID), Integer.parseInt(productID));
                shoppingCart.setNum(Integer.parseInt(resultSet.getString(3)));
            }
            if (shoppingCart != null) {
                System.out.println("getByUserId_ProId Success");
            } else {
                System.out.println("getByUserId_ProId False");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return shoppingCart;
    }

    @Override
    public boolean update(ShoppingCart shoppingCart) {
        connection = jdbcUtils.getConnection();
        String sql = "UPDATE `shoppingCart` SET num = ? WHERE userID=? && productID=?;";
        boolean flag = false;
        try {
            System.out.println("update pro");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shoppingCart.getNum().toString());
            preparedStatement.setString(2, shoppingCart.getUserID().toString());
            preparedStatement.setString(3, shoppingCart.getProductID().toString());
            if (preparedStatement.executeUpdate() == 1) flag = true;
            System.out.println(flag);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return flag;
    }

    @Override
    public boolean add(ShoppingCart shoppingCart) {
        connection = jdbcUtils.getConnection();
        String sql = "INSERT INTO  `shoppingCart` set userID=? , productID=?, num=?;";
        boolean flag = false;
        try {
            System.out.println("add pro");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shoppingCart.getUserID().toString());
            preparedStatement.setString(2, shoppingCart.getProductID().toString());
            preparedStatement.setString(3, shoppingCart.getNum().toString());
            if (preparedStatement.executeUpdate() == 1) flag = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return flag;
    }

    @Override
    public boolean clearByUserId(String userID) {
        connection = jdbcUtils.getConnection();
        String sql = "delete from shoppingCart WHERE userID=?;";
        boolean flag = false;
        try {
            //查看数据库中是否存在
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userID);
            if (preparedStatement.executeUpdate() == 1)
                flag = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        return flag;
    }

    @Override
    public boolean clearByUserId_ProId(String userID, String productId) {
        connection = jdbcUtils.getConnection();
        String sql = "delete from shoppingCart WHERE userID=? && productID=?;";
        boolean flag = false;
        try {
            //查看数据库中是否存在
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, productId);
            if (preparedStatement.executeUpdate() == 1)
                flag = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        return flag;
    }
}
