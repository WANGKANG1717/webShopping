package com.example.javaWeb.service;

import com.example.javaWeb.entity.Product;
import com.example.javaWeb.entity.ShoppingCart;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/11:41
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface ShoppingCartService {
    public ArrayList<Product> getShoppingCart(String userID);

    public boolean AddShoppingCart(ShoppingCart shoppingCart);

    public boolean ClearShoppingCart(String userID);

    public  boolean ClearShoppingCart(String userID, String productID);
}
