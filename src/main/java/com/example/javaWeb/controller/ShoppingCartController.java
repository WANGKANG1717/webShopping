package com.example.javaWeb.controller;

import com.example.javaWeb.dao.ShoppingCartDao;
import com.example.javaWeb.entity.Product;
import com.example.javaWeb.entity.ShoppingCart;
import com.example.javaWeb.service.ShoppingCartService;
import com.example.javaWeb.service.imp.ShoppingCartServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "shoppingCart", value = "/shoppingCart")
public class ShoppingCartController extends HttpServlet {
    private ShoppingCartService shoppingCartService=new ShoppingCartServiceImp();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取参数识别用户想要请求的方法
         * 然后判断并调用对应的方法
         */
        String method = req.getParameter("method");
        if ("add".equals(method)) {
            addShoppingCart(req, resp);
        } else if ("get".equals(method)) {
            getShoppingCart(req, resp);
        } else if ("clear".equals(method)) {
            clearShoppingCart(req, resp);
        }
    }
    //    添加购物车
    public void addShoppingCart(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("addShoppingCart");
        Integer userID = Integer.parseInt(request.getParameter("userID"));
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer buyNum = Integer.parseInt(request.getParameter("buyNum"));
        System.out.println(userID + " " + productId + " " +buyNum);
        boolean flag = shoppingCartService.AddShoppingCart(new ShoppingCart(userID, productId, buyNum));
        String info = "";
        if (flag) {
            info = "添加购物车成功";
        } else {
            info = "添加购物车失败";
        }
        ArrayList<Product> products = shoppingCartService.getShoppingCart(userID.toString());
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
    public void getShoppingCart(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getShoppingCart");
        String userID = request.getParameter("userID");
        System.out.println(userID);
        /**
         * 得到购物车内容，将数据传回去
         */
        ArrayList<Product> products = shoppingCartService.getShoppingCart(userID);
        request.getSession().setAttribute("shoppingCard", products);
        try {
            request.getRequestDispatcher("/cart_view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearShoppingCart(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("clearShoppingCart");
        String userID = request.getParameter("userID");
        System.out.println(userID);
        boolean flag = shoppingCartService.ClearShoppingCart(userID);
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
