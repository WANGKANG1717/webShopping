package com.example.javaWeb.dao.imp;

import com.example.javaWeb.dao.ProductDao;
import com.example.javaWeb.entity.Product;
import com.example.javaWeb.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/10:40
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class ProductDaoImp implements ProductDao {
    private JDBCUtils jdbcUtils = new JDBCUtils();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProductDaoImp() {
        super();
    }

    @Override
    public Product getById(String id) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from product where id=?;";
        Product product=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                product=new Product();
                product.setId(Integer.parseInt(resultSet.getString(1)));
                product.setName(resultSet.getString(2));
                product.setPrice(Double.parseDouble(resultSet.getString(3)));
                product.setPro_price(Double.parseDouble(resultSet.getString(4)));
                product.setInventory(Integer.parseInt(resultSet.getString(5)));
                product.setSales(Integer.parseInt(resultSet.getString(6)));
                product.setImg(resultSet.getString(7));
                product.setCategory(resultSet.getString(8));
                product.setFan_material(resultSet.getString(9));
                product.setFan_bone_material(resultSet.getString(10));
                product.setFan_bone_num(Integer.parseInt(resultSet.getString(11)));
                product.setFan_bone_length(Integer.parseInt(resultSet.getString(12)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return product;
    }

    @Override
    public ArrayList<Product> getAll() {
        connection = jdbcUtils.getConnection();
        String sql = "select * from product;";
        ArrayList<Product> products = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(Integer.parseInt(resultSet.getString(1)));
                product.setName(resultSet.getString(2));
                product.setPrice(Double.parseDouble(resultSet.getString(3)));
                product.setPro_price(Double.parseDouble(resultSet.getString(4)));
                product.setInventory(Integer.parseInt(resultSet.getString(5)));
                product.setSales(Integer.parseInt(resultSet.getString(6)));
                product.setImg(resultSet.getString(7));
                product.setCategory(resultSet.getString(8));
                product.setFan_material(resultSet.getString(9));
                product.setFan_bone_material(resultSet.getString(10));
                product.setFan_bone_num(Integer.parseInt(resultSet.getString(11)));
                product.setFan_bone_length(Integer.parseInt(resultSet.getString(12)));
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return products;
    }

    @Override
    public ArrayList<Product> getByCategory(String category) {
        connection = jdbcUtils.getConnection();
        String sql = "SELECT * from product WHERE category LIKE ?;";
        ArrayList<Product> products = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+category+"%");
            //执行sql语句之前需要给参数赋值
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(Integer.parseInt(resultSet.getString(1)));
                product.setName(resultSet.getString(2));
                product.setPrice(Double.parseDouble(resultSet.getString(3)));
                product.setPro_price(Double.parseDouble(resultSet.getString(4)));
                product.setInventory(Integer.parseInt(resultSet.getString(5)));
                product.setSales(Integer.parseInt(resultSet.getString(6)));
                product.setImg(resultSet.getString(7));
                product.setCategory(resultSet.getString(8));
                product.setFan_material(resultSet.getString(9));
                product.setFan_bone_material(resultSet.getString(10));
                product.setFan_bone_num(Integer.parseInt(resultSet.getString(11)));
                product.setFan_bone_length(Integer.parseInt(resultSet.getString(12)));
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return products;
    }

    @Override
    public Integer getNumByCategory(String category) {
        connection = jdbcUtils.getConnection();
        String sql = "SELECT Count(*) FROM product WHERE category like ?;";
        ArrayList<Product> allProducts = new ArrayList<>();
        Integer num=0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+category+"%");
            //执行sql语句之前需要给参数赋值
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()) {
                num=Integer.parseInt(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return num;
    }

    @Override
    public boolean deleteByID(String id) {
        return false;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }
}
