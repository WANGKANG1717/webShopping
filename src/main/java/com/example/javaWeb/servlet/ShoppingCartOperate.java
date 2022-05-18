package com.example.javaWeb.servlet;

import com.example.javaWeb.entity.Product;
import com.example.javaWeb.entity.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShoppingCart", value = "/ShoppingCart")
public class ShoppingCartOperate extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取参数识别用户想要请求的方法
         * 然后判断并调用对应的方法
         */
        String method = req.getParameter("method");
        if ("post".equals(method)) {
            doPost(req, resp);
        } else if ("get".equals(method)) {
            doGet(req, resp);
        } else if ("clear".equals(method)) {
            doClear(req, resp);
        }
    }
    //    添加购物车
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("AddShoppingCart");
        String userID = request.getParameter("userID");
        String productId = request.getParameter("productId");
        System.out.println(userID + " " + productId);
        Integer buyNum = Integer.parseInt(request.getParameter("buyNum"));
        boolean flag = ShoppingCart.AddShoppingCart(userID, productId, buyNum);
        String info = "";
        if (flag) {
            info = "添加购物车成功";
        } else {
            info = "添加购物车失败";
        }
        /**
         * 以下作废，采用了更好的架构
         */
//        if (products!=null) {
//            products=ShoppingCart.getShoppingCart(userID);
//            //使用hashmap去重
//            HashMap<Integer, Integer> map=new HashMap<>();
//            for(int i=0; i<shoppingCart.length; i++) {
//                Integer proId=Integer.parseInt(shoppingCart[i]);
//                if(map.containsKey(proId)==false) {
//                    map.put(proId, 1);
//                }
//                else {
//                    map.replace(proId, map.get(proId)+1);
//                }
//            }
//            //将数据添加到ArrayList中
//            for(Integer id:map.keySet()) {
//                Product product=Product.getProduct(id);
//                product.setNum(map.get(id));
//                products.add(product);
//            }
//        //将数据传回去
//        }
        ArrayList<Product> products = ShoppingCart.getShoppingCart(userID);
        request.getSession().setAttribute("shoppingCard", products);
        request.getSession().setAttribute("info", info);
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
        System.out.println("getShoppingCart");
        String userID = request.getParameter("userID");
        System.out.println(userID);
        /**
         * 得到购物车内容，将数据传回去
         */
        ArrayList<Product> products = ShoppingCart.getShoppingCart(userID);
        request.getSession().setAttribute("shoppingCard", products);
//        String[] shoppingCart=User.toArray(User.getShoppingCart(userID));
//        if (shoppingCart!=null) {
//            ArrayList<Product> products=new ArrayList<>();
//            //使用hashmap去重
//            HashMap<Integer, Integer> map=new HashMap<>();
//            for(int i=0; i<shoppingCart.length; i++) {
//                Integer proId=Integer.parseInt(shoppingCart[i]);
//                if(map.containsKey(proId)==false) {
//                    map.put(proId, 1);
//                }
//                else {
//                    map.replace(proId, map.get(proId)+1);
//                }
//            }
//            //将数据添加到ArrayList中
//            for(Integer id:map.keySet()) {
//                Product product=Product.getProduct(id);
//                product.setNum(map.get(id));
//                products.add(product);
//            }
//            //将数据传回去
//            request.getSession().setAttribute("shoppingCard", products);
//        }
        try {
            request.getRequestDispatcher("/cart_view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doClear(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("CLearShoppingCart");
        String userID = request.getParameter("userID");
        System.out.println(userID);
        boolean flag = ShoppingCart.ClearShoppingCart(userID);
        String info = "";
        if (flag) {
            info = "删除购物车成功";
        } else {
            info = "删除购物车失败";
        }
        request.getSession().setAttribute("shoppingCard", null);
        request.getSession().setAttribute("info", info);
        try {
            request.getRequestDispatcher("/cart_view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
