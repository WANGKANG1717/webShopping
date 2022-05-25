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
        //得到查询到的所有产品总数，写到第一个产品中去，这样可以避免再次查询数据库
        Integer TotalNum=allProducts.size();
        for(int i=0; i<allProducts.size(); i++) {
            allProducts.get(i).setTotalNum(TotalNum);
        }
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
    public ArrayList<Product> getProducts(Integer page, Integer limit, String priceOrder, String salesOrder, String keyword) {
        //四个比较器
        Comparator<Product> priceUp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice()>o2.getPrice()) return 1;
                else if(o1.getPrice()==o2.getPrice()) return 0;
                else return -1;
            }
        };
        Comparator<Product> priceDown = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice()>o2.getPrice()) return -1;
                else if(o1.getPrice()==o2.getPrice()) return 0;
                else return 1;
            }
        };
        Comparator<Product> salesUp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getSales()- o2.getSales();
            }
        };
        Comparator<Product> salesDown = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getSales() - o1.getSales();
            }
        };
        //模糊查询
        ArrayList<Product> allProducts=productDao.getByKeyword(keyword);
        if(priceOrder.equals("price+")) {
            allProducts.sort(priceUp);
        }
        else if(priceOrder.equals("price-")) {
            allProducts.sort(priceDown);
        }
        if(salesOrder.equals("sales+")) {
            allProducts.sort(salesUp);
        }
        else if(salesOrder.equals("sales-")) {
            allProducts.sort(salesDown);
        }
        //得到查询到的所有产品总数，写到第一个产品中去，这样可以避免再次查询数据库
        Integer TotalNum=allProducts.size();
        for(int i=0; i<allProducts.size(); i++) {
            allProducts.get(i).setTotalNum(TotalNum);
        }
        //
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
