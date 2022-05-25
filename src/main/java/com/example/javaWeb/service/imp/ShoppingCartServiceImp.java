package com.example.javaWeb.service.imp;

import com.example.javaWeb.dao.ProductDao;
import com.example.javaWeb.dao.ShoppingCartDao;
import com.example.javaWeb.dao.imp.ProductDaoImp;
import com.example.javaWeb.dao.imp.ShoppingCartDaoImp;
import com.example.javaWeb.entity.Product;
import com.example.javaWeb.entity.ShoppingCart;
import com.example.javaWeb.service.ShoppingCartService;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/11:43
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class ShoppingCartServiceImp implements ShoppingCartService {
    private ShoppingCartDao shoppingCartDao=new ShoppingCartDaoImp();
    private ProductDao productDao=new ProductDaoImp();

    public ShoppingCartServiceImp() {
        super();
    }

    @Override
    public ArrayList<Product> getShoppingCart(String userID) {
        ArrayList<Product> products=new ArrayList<>();
        ShoppingCart shoppingCart=null;
        //
        ArrayList<ShoppingCart> shoppingCarts=shoppingCartDao.getByUserId(userID);
        for(int i=0; i<shoppingCarts.size(); i++) {
            shoppingCart=shoppingCarts.get(i);
            Product product=productDao.getById(shoppingCart.getProductID().toString());
            product.setNum(Integer.parseInt(shoppingCart.getNum().toString()));
            //只有大于零的才能展示
            if(product.getNum()>0){
                products.add(product);
            }
        }
        if (products.size()>0) {
            System.out.println("getShoppingCart Success");
        } else {
            System.out.println("getShoppingCart False");
        }
        return products;
    }

    @Override
    public boolean AddShoppingCart(ShoppingCart shoppingCart) {
        boolean flag=false;
        ShoppingCart shoppingCart1=null;
        shoppingCart1=shoppingCartDao.getByUserId_ProId(shoppingCart.getUserID().toString(), shoppingCart.getProductID().toString());
        if(shoppingCart1!=null) {
            shoppingCart1.setNum(shoppingCart1.getNum()+shoppingCart.getNum());
            if(shoppingCart1.getNum()<=0) {
                System.out.println("更新后商品数量小于等于0");
                return false;
            }
            else flag=shoppingCartDao.update(shoppingCart1);
        }
        else {
            //数据库中不存在，且要添加的商品数量小于等于0
            if(shoppingCart.getNum()<=0) {
                System.out.println("要添加的商品数量小于0");
                return false;
            }
            else flag=shoppingCartDao.add(shoppingCart);
        }
        return flag;
    }

    @Override
    public boolean ClearShoppingCart(String userID) {
        return shoppingCartDao.clearByUserId(userID);
    }

    @Override
    public boolean ClearShoppingCart(String userID, String productID) {
        return shoppingCartDao.clearByUserId_ProId(userID, productID);
    }
}
