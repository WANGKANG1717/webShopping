package com.example.javaWeb.Bean;

import com.example.javaWeb.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingCart {
    Integer userID;
    Integer productID;
    Integer num;

    //
    private static JDBCUtils jdbcUtils = new JDBCUtils();
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public Integer getUserID() { return userID; }

    public void setUserID(Integer userID) { this.userID = userID; }

    public Integer getProductID() { return productID; }

    public void setProductID(Integer productID) { this.productID = productID; }

    public Integer getNum() { return num; }

    /**
     * 根据用户ID得到购物车
     * @param userID
     * @return
     */
    public static ArrayList<Product> getShoppingCart(String userID) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from shoppingCart where userID=?;";
        ResultSet resultSet = null;
        ArrayList<Product> products=new ArrayList<>();;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, userID);
            //执行sql语句
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                String productID=resultSet.getString(2);
                String num=resultSet.getString(3);
                Product product=Product.getProduct(Integer.parseInt(productID));
                product.setNum(Integer.parseInt(num));
                products.add(product);
            }
            System.out.println(products.size()+"adasdasdasdsdsd");
            if (products!=null) {
                System.out.println("获得购物车成功");
            } else {
                System.out.println("获得购物车失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return products;
    }

    /**
     * 添加购物车
     * 如果购物车中存在则更新
     * 不存在则插入
     * @param userID 用户ID
     * @param productId 产品ID
     * @param buyNum 购买数量
     * @return
     */
    public static boolean AddShoppingCart(String userID, String productId, Integer buyNum) {
        connection = jdbcUtils.getConnection();
        //查看购物车中是否存在
        String sql="select * from shoppingCart where userID=? && productID=?;";
        //存在则更新
        String sql2="UPDATE `shoppingCart` SET num = ? WHERE userID=? && productID=?;";
        //不存在则插入
        String sql3="INSERT INTO  `shoppingCart` set userID=? , productID=?, num=?;";
        boolean flag=false;
        try {
            //查看数据库中是否存在
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, productId);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()) {
                Integer num=Integer.parseInt(resultSet.getString(3))+buyNum;
                System.out.println(num+"dadada");
                //存在执行更新
                System.out.println("存在执行更新");
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setString(1, num.toString());
                preparedStatement.setString(2, userID);
                preparedStatement.setString(3, productId);
                if(preparedStatement.executeUpdate()==1) flag=true;
                System.out.println(flag);
            }
            else {
                //不存在执行插入
                System.out.println("不存在执行插入");
                Integer num= buyNum;
                preparedStatement = connection.prepareStatement(sql3);
                preparedStatement.setString(1, userID);
                preparedStatement.setString(2, productId);
                preparedStatement.setString(3, num.toString());
                preparedStatement.execute();
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return flag;
    }
}
