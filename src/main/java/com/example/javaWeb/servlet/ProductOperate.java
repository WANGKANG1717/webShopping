package com.example.javaWeb.servlet;

import com.example.javaWeb.Bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "getProduct", value = "/getProduct")
public class ProductOperate extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取参数识别用户想要请求的方法
         * 然后判断并调用对应的方法
         */
        String method = req.getParameter("method");
        if ("get".equals(method)) {
            doGet(req, resp);
        } else if ("post".equals(method)) {
            doPost(req, resp);
        } else if ("getNewProduct".equals(method)) {
            getNewProduct(req, resp);
        }
    }

    //得到单个商品的信息
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getProuct");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Product product = Product.getProduct(id);
//        HttpSession session = request.getSession();
//        session.setAttribute("product", "1231323");
        request.getSession().setAttribute("product", product);
        try {
            request.getRequestDispatcher("/item.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //得到多个商品的信息
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getProucts");
        Integer page = Integer.parseInt(request.getParameter("page"));        //第几页
        Integer limit = Integer.parseInt(request.getParameter("limit"));       //一页限制多少个
        String category = request.getParameter("category");                 //请求的产品类型
        //进行查询
        ArrayList<Product> products = Product.getProducts(page, limit, category);
        //查询总的个数
        //方便判断页数
        Integer TotalNum=Product.getProductsNum(category);
//        ArrayList<Product> products = Product.getAllProduct();
        if (products != null) {
            request.getSession().removeAttribute("products");
            request.getSession().setAttribute("products", products);
            request.getSession().setAttribute("page", page);            //当前页数
            request.getSession().setAttribute("category", category);    //当前查找的类型
            request.getSession().setAttribute("TotalNUm", TotalNum);    //产品的总数
            request.getSession().setAttribute("PageNum", TotalNum / limit + (TotalNum % limit != 0 ? 1 : 0));   //总的页数(向上取整)
        }
        try {
            request.getRequestDispatcher("/product.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getNewProduct(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getNewProucts");
        ArrayList<Product> products = Product.getProducts(1, 6, "");
        request.getSession().setAttribute("newProducts", products);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
