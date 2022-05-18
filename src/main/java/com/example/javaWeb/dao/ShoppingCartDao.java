package com.example.javaWeb.dao;

import com.example.javaWeb.entity.ShoppingCart;

import java.util.ArrayList;

public interface ShoppingCartDao {
    public ArrayList<ShoppingCart> getByUserId(String userID);

    public ShoppingCart getByUserId_ProId(String userID, String productID);

    public boolean update(ShoppingCart shoppingCart);

    public boolean add(ShoppingCart shoppingCart);

    public boolean clearByUserId(String userID);

    public boolean clearByUserId_ProId(String userID, String productId);
}
