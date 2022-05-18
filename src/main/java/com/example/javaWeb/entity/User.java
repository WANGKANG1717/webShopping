package com.example.javaWeb.entity;

import com.example.javaWeb.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private Integer id;
    private String name;
    private String passwd;
    private String sex;
    private String[] hobby;
    private int online;
    private String[] shopping_cart;

    private Double balance;
    //
    private static JDBCUtils jdbcUtils = new JDBCUtils();
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public User() {
        name = "";
        passwd = "";
        sex = "";
        hobby = null;
    }

    public User(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public User(String name, String passwd, String sex, String[] hobby) {
        this.name = name;
        this.passwd = passwd;
        this.sex = sex;
        this.hobby = hobby;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return this.name;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    public String[] getHobby() { return hobby; }

    public void setHobby(String[] hobby) { this.hobby = hobby; }

    public int getOnline() { return online; }

    public void setOnline(int online) { this.online = online; }

    public String[] getShopping_cart() { return shopping_cart; }

    public void setShopping_cart(String[] shopping_cart) { this.shopping_cart = shopping_cart; }

    public Double getBalance() { return balance; }

    public void setBalance(Double balance) { this.balance = balance;}

    //创建User对象可用
    public boolean AddUser() {
        connection = jdbcUtils.getConnection();
        String sql = "INSERT INTO  `user` set username=? , passwd=?, sex=?, hobby=?;";
        int res = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, passwd);
            preparedStatement.setString(3, sex);
            String Hobby = "";
            for (int i = 0; i < hobby.length - 1; i++) {
                Hobby += hobby[i];
                Hobby += ',';
            }
            Hobby += hobby[hobby.length - 1];
            preparedStatement.setString(4, Hobby);
            res = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //记得关闭连接，虽然不会影响程序，但是会在结束的时候报个小错，还是挺难受的（对我这个qpz）
        jdbcUtils.close(connection, preparedStatement, null);
        if (res != 0) return true;
        else return false;
    }

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

    //静态方法，直接调用
    //添加用户
    public static boolean AddUser(String username, String password, String sex, String[] hobby) {
        connection = jdbcUtils.getConnection();
        String sql = "INSERT INTO  `user` set username=? , passwd=?, sex=?, hobby=?;";
        int res = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, sex);
            String Hobby = toString(hobby);
            preparedStatement.setString(4, Hobby);
            res = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        if (res != 0) return true;
        else return false;
    }

    //静态方法，直接调用
    //登录判断用户名和密码
    //返回查询到的用户信息
    public static User Login(String username, String password) {
        connection = jdbcUtils.getConnection();
        String sql = "select * from user where username=? and passwd=?";
        String sql2 = "UPDATE `user` SET online = 1 WHERE online = 0 AND id=?;";
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
                user.setSex(resultSet.getString(4));
                user.setHobby(toArray(resultSet.getString(5)));
                user.setOnline(1);      //设置为在线
                user.setBalance(Double.parseDouble(resultSet.getString(7)));
                //更改在线状态
                /**
                 * 这里有点冗余
                 */
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setString(1, user.getId().toString());
                preparedStatement.executeUpdate();
                System.out.println("用户登录成功111");
            } else {
                System.out.println("用户登录失败222");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return user;
    }

    /**
     * 用用户名比较恶心
     * 因此全部改成 userID
     * @param userID
     * @return
     */
    public static boolean Exit(String userID) {
        connection = jdbcUtils.getConnection();
        String sql = "UPDATE `user` SET online = 0 WHERE online = 1 AND id=?;";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, userID);
            //执行sql语句
            int res = preparedStatement.executeUpdate();
            if (res>0) {
                flag=true;
                System.out.println("用户下线成功333");
            } else {
                System.out.println("用户下线失败444");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        return flag;
    }
/*
    public static String getShoppingCart(String userID) {
        connection = jdbcUtils.getConnection();
        String sql = "select shopping_cart from user where id=?;";
        ResultSet resultSet = null;
        String shoppingCart=null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, userID);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                shoppingCart=resultSet.getString(1);
                System.out.println("获得购物车成功");
            } else {
                System.out.println("获得购物车失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, resultSet);
        return shoppingCart;
    }
*/
    /**
     * 添加购物车
     * @param userID 用户ID
     * @param productId 产品ID
     * @param buyNum 购买数量
     * @return
     */
    /*
    public static boolean AddShoppingCart(String userID, String productId, Integer buyNum) {
        //原来的购物车加现在的购物车
        String products=getShoppingCart(userID);
        if(products!=null && !products.equals("")) {
            for(int i=0; i<buyNum; i++) {
                products=products+","+productId;
            }
        }
        else {
            products=productId;
            for(int i=1; i<buyNum; i++) {
                products=products+","+productId;
            }
        }
        connection = jdbcUtils.getConnection();
        String sql = "UPDATE `user` SET shopping_cart = ? WHERE id = ?;";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //执行sql语句之前需要给参数赋值
            preparedStatement.setString(1, products);
            preparedStatement.setString(2, userID);
            //执行sql语句
            int res = preparedStatement.executeUpdate();
            if (res>0) {
                flag=true;
                System.out.println("购物车更新成功");
            } else {
                System.out.println("购物车更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcUtils.close(connection, preparedStatement, null);
        return flag;
    }
    */
}
