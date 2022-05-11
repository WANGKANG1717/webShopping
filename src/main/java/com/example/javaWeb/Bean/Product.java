package com.example.javaWeb.Bean;

import com.example.javaWeb.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Double pro_price;
    private Integer inventory;
    private Integer sales;
    private String img;
    private String category;
    private String fan_material;
    private String fan_bone_material;
    private Integer fan_bone_num;
    private Integer fan_bone_length;

    //购物车中数量
    private Integer num;

    //总价
    private Double total_price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPro_price() { return pro_price; }

    public void setPro_price(Double pro_price) { this.pro_price = pro_price; }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFan_material() {
        return fan_material;
    }

    public void setFan_material(String fan_material) {
        this.fan_material = fan_material;
    }

    public String getFan_bone_material() {
        return fan_bone_material;
    }

    public void setFan_bone_material(String fan_bone_material) {
        this.fan_bone_material = fan_bone_material;
    }

    public Integer getFan_bone_num() {
        return fan_bone_num;
    }

    public void setFan_bone_num(Integer fan_bone_num) {
        this.fan_bone_num = fan_bone_num;
    }

    public Integer getFan_bone_length() {
        return fan_bone_length;
    }

    public void setFan_bone_length(Integer fan_bone_length) {
        this.fan_bone_length = fan_bone_length;
    }

    public Integer getNum() { return num; }

    public void setNum(Integer num) { this.num = num; }

    public Double getTotal_price() {
        this.setTotal_price();
        return total_price;
    }

    public void setTotal_price() {
        this.total_price = this.getPro_price()*this.getNum();
    }

    private static JDBCUtils jdbcUtils = new JDBCUtils();
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    /**
     * 得到单个产品信息
     * @param id
     * @return
     */
    public static Product getProduct(Integer id) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from product where id=?;";
        Product product = new Product();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
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

    public static ArrayList<Product> getAllProduct() {
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

    public static ArrayList<Product> getProducts(Integer page, Integer limit, String category) {
        connection = jdbcUtils.getConnection();
        String sql = "SELECT * from product WHERE category LIKE ?;";
        ArrayList<Product> allProducts = new ArrayList<>();
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
                allProducts.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        ArrayList<Product> products=new ArrayList<>();
        if(page<=0 || allProducts.size()<=((page-1)*limit)) {
            return products;
        }
        else {
            for(int i=(page-1)*limit; i<allProducts.size() && i<page*limit; i++) {
                products.add(allProducts.get(i));
            }
            return products;
        }
    }

    public static Integer getProductsNum(String category) {
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
}
