package com.example.javaWeb.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingCart {
    Integer userID;
    Integer productID;
    Integer num;

    public ShoppingCart() {}

    public ShoppingCart(Integer userID) {
        this.userID=userID;
    }

    public ShoppingCart(Integer userID, Integer productID) {
        this.userID=userID;
        this.productID=productID;
    }

    public ShoppingCart(Integer userID, Integer productID, Integer num) {
        this.userID=userID;
        this.productID=productID;
        this.num=num;
    }

    public Integer getUserID() { return userID; }

    public void setUserID(Integer userID) { this.userID = userID; }

    public Integer getProductID() { return productID; }

    public void setProductID(Integer productID) { this.productID = productID; }

    public void setNum(Integer num) { this.num = num; }

    public Integer getNum() { return num; }
}
