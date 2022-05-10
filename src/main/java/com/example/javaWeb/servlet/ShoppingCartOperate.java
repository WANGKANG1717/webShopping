package com.example.javaWeb.servlet;

import com.example.javaWeb.Bean.Product;
import com.example.javaWeb.Bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "addShoppingCart", value = "/addShoppingCart")
public class ShoppingCartOperate extends HttpServlet {
//    添加购物车
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("AddShoppingCart");
        String username = request.getParameter("username");
        String productId = request.getParameter("productId");
        Integer buyNum = Integer.parseInt(request.getParameter("buyNum"));
        boolean flag=User.AddShoppingCart(username, productId, buyNum);
        String info="";
        if(flag) {
            info="添加购物车成功";
        }
        else {
            info = "添加购物车失败";
        }
        String[] shoppingCart=User.toArray(User.getShoppingCart(username));
        if (shoppingCart!=null) {
            ArrayList<Product> products=new ArrayList<>();
            //使用hashmap去重
            HashMap<Integer, Integer> map=new HashMap<>();
            for(int i=0; i<shoppingCart.length; i++) {
                Integer proId=Integer.parseInt(shoppingCart[i]);
                if(map.containsKey(proId)==false) {
                    map.put(proId, 1);
                }
                else {
                    map.replace(proId, map.get(proId)+1);
                }
            }
            //将数据添加到ArrayList中
            for(Integer id:map.keySet()) {
                Product product=Product.getProduct(id);
                product.setNum(map.get(id));
                products.add(product);
            }
            //将数据传回去
            request.getSession().setAttribute("shoppingCard", products);
            request.getSession().setAttribute("info", info);
        }
        try {
            request.getRequestDispatcher("/cart_view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    查询购物车内容
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("AddShoppingCart");
        String username = request.getParameter("username");
        String[] shoppingCart=User.toArray(User.getShoppingCart(username));
        if (shoppingCart!=null) {
            ArrayList<Product> products=new ArrayList<>();
            //使用hashmap去重
            HashMap<Integer, Integer> map=new HashMap<>();
            for(int i=0; i<shoppingCart.length; i++) {
                Integer proId=Integer.parseInt(shoppingCart[i]);
                if(map.containsKey(proId)==false) {
                    map.put(proId, 1);
                }
                else {
                    map.replace(proId, map.get(proId)+1);
                }
            }
            //将数据添加到ArrayList中
            for(Integer id:map.keySet()) {
                Product product=Product.getProduct(id);
                product.setNum(map.get(id));
                products.add(product);
            }
            //将数据传回去
            request.getSession().setAttribute("shoppingCard", products);
        }
        try {
            request.getRequestDispatcher("/cart_view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
