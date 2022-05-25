package com.example.javaWeb.service.imp;

import com.example.javaWeb.dao.ProductDao;
import com.example.javaWeb.dao.imp.ProductDaoImp;
import com.example.javaWeb.entity.Product;
import com.example.javaWeb.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/10:46
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class ProductServiceImp implements ProductService {
    ProductDao productDao = new ProductDaoImp();

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
        ArrayList<Product> allProducts = productDao.getByCategory(category);
        ArrayList<Product> products = new ArrayList<>();
        //得到查询到的所有产品总数，写到第一个产品中去，这样可以避免再次查询数据库
        Integer TotalNum = allProducts.size();
        for (int i = 0; i < allProducts.size(); i++) {
            allProducts.get(i).setTotalNum(TotalNum);
        }
        if (page <= 0 || allProducts.size() <= ((page - 1) * limit)) {
            return products;
        } else {
            for (int i = (page - 1) * limit; i < allProducts.size() && i < page * limit; i++) {
                products.add(allProducts.get(i));
            }
            return products;
        }
    }

    @Override
    public ArrayList<Product> getProducts(Integer page, Integer limit, String priceOrder, String salesOrder, String keyword) {
        //四个比较器
        Comparator<Product> priceUp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPro_price(), o2.getPro_price());
            }
        };
        Comparator<Product> priceDown = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -1*Double.compare(o1.getPro_price(), o2.getPro_price());
            }
        };
        Comparator<Product> salesUp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getSales(), o2.getSales());
            }
        };
        Comparator<Product> salesDown = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -1*Integer.compare(o1.getSales(), o2.getSales());
            }
        };
        //模糊查询
        ArrayList<Product> allProducts = productDao.getByKeyword(keyword);
        if (priceOrder.equals("price+")) {
            allProducts.sort(priceUp);
        } else if (priceOrder.equals("price-")) {
            allProducts.sort(priceDown);
        }
        if (salesOrder.equals("sales+")) {
            allProducts.sort(salesUp);
        } else if (salesOrder.equals("sales-")) {
            allProducts.sort(salesDown);
        }
        //得到查询到的所有产品总数，写到第一个产品中去，这样可以避免再次查询数据库
        Integer TotalNum = allProducts.size();
        for (int i = 0; i < allProducts.size(); i++) {
            allProducts.get(i).setTotalNum(TotalNum);
        }
        //
        ArrayList<Product> products = new ArrayList<>();
        if (page <= 0 || allProducts.size() <= ((page - 1) * limit)) {
            return products;
        } else {
            for (int i = (page - 1) * limit; i < allProducts.size() && i < page * limit; i++) {
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
