package com.example.javaWeb.service;

import com.example.javaWeb.dao.ProductDao;
import com.example.javaWeb.dao.imp.ProductDaoImp;
import com.example.javaWeb.entity.Product;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/10:44
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface ProductService {
    public Product getProduct(Integer id);

    public ArrayList<Product> getAllProduct();

    public ArrayList<Product> getProducts(Integer page, Integer limit, String category);

    public Integer getProductsNum(String category);
}
