package com.example.javaWeb.dao;

import com.example.javaWeb.entity.Product;
import com.example.javaWeb.entity.User;

import java.util.ArrayList;

public interface ProductDao {
    public Product getById(String id);

    public ArrayList<Product> getAll();

    public ArrayList<Product> getByCategory(String category);

    public ArrayList<Product> getByKeyword(String keyword);

    public Integer getNumByCategory(String category);

    /**
     * 以下暂不实现
     */
    public boolean deleteByID(String id);

    public boolean add(Product product);
}
