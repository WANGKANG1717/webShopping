package com.example.javaWeb.service.imp;

import com.example.javaWeb.dao.ProductDao;
import com.example.javaWeb.dao.imp.ProductDaoImp;
import com.example.javaWeb.entity.Product;
import com.example.javaWeb.service.ProductService;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/10:46
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class ProductServiceImp implements ProductService {
    ProductDao productDao=new ProductDaoImp();

    @Override
    public Product getProduct(Integer id) {
        return productDao.getById(id.toString());
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return productDao.getAll();
    }

    @Override
    public ArrayList<Product> getProducts(Integer page, Integer limit, String category) {
        ArrayList<Product> allProducts=productDao.getByCategory(category);
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

    @Override
    public Integer getProductsNum(String category) {
        return productDao.getNumByCategory(category);
    }
}
