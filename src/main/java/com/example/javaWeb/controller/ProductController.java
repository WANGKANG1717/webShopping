package com.example.javaWeb.controller;

import com.example.javaWeb.entity.Product;
import com.example.javaWeb.service.ProductService;
import com.example.javaWeb.service.imp.ProductServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


@WebServlet(name = "product", value = "/product")
public class ProductController extends HttpServlet {
    ProductService productService = new ProductServiceImp();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取参数识别用户想要请求的方法
         * 然后判断并调用对应的方法
         */
        String method = req.getParameter("method");
        if ("get".equals(method)) {
            getProduct(req, resp);
        } else if ("getAll".equals(method)) {
            getAllProduct(req, resp);
        } else if ("getNew".equals(method)) {
            getNewProduct(req, resp);
        } else if ("search".equals(method)) {
            searchProduct(req, resp);
        }
    }

    //得到单个商品的信息
    public void getProduct(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getProduct");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
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
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getAllProduct");
        Integer page = Integer.parseInt(request.getParameter("page"));        //第几页
        Integer limit = Integer.parseInt(request.getParameter("limit"));       //一页限制多少个
        String category = request.getParameter("category");                 //请求的产品类型
        System.out.println(page + " " + limit + " " + category);
        //进行查询
        ArrayList<Product> products = productService.getProducts(page, limit, category);
        //查询总的个数
        //方便判断页数
        Integer TotalNum = 0;
        if(products.size()>0) {
            TotalNum = products.get(0).getTotalNum();
        }
        if (products != null) {
            request.getSession().removeAttribute("products");
            request.getSession().setAttribute("products", products);
            request.getSession().setAttribute("Page", page);            //当前页数
            request.getSession().setAttribute("category", category);    //当前查找的类型
            request.getSession().setAttribute("TotalNum", TotalNum);    //产品的总数
            request.getSession().setAttribute("PageNum", TotalNum / limit + (TotalNum % limit != 0 ? 1 : 0));   //总的页数(向上取整)
            request.getSession().setAttribute("getType", "getAllProduct");
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
        ArrayList<Product> products = productService.getProducts(1, 6, "");
        request.getSession().setAttribute("newProducts", products);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("searchProduct");
        Integer page = Integer.parseInt(request.getParameter("page"));        //第几页
        Integer limit = Integer.parseInt(request.getParameter("limit"));       //一页限制多少个
        String priceSelect = request.getParameter("priceSelect");
        String salesSelect = request.getParameter("salesSelect");
        String keyword = request.getParameter("keyword");
        System.out.println(page + " " + limit + " " + priceSelect + " " + salesSelect + " " + keyword);
        //进行查询
        ArrayList<Product> products = productService.getProducts(page, limit, priceSelect, salesSelect, keyword);
        //查询总的个数
        //方便判断页数
        Integer TotalNum = 0;
        if(products.size()>0) {
            TotalNum = products.get(0).getTotalNum();
        }
        if (products != null) {
            request.getSession().removeAttribute("products");
            request.getSession().setAttribute("products", products);
            request.getSession().setAttribute("Page", page);            //当前页数
            request.getSession().setAttribute("keyword", keyword);    //当前查找的类型
            request.getSession().setAttribute("TotalNum", TotalNum);    //产品的总数
            request.getSession().setAttribute("PageNum", TotalNum / limit + (TotalNum % limit != 0 ? 1 : 0));   //总的页数(向上取整)
            request.getSession().setAttribute("priceSelect", priceSelect);            //当前页数
            request.getSession().setAttribute("salesSelect", salesSelect);
            request.getSession().setAttribute("getType", "searchProduct");
        }
        try {
            request.getRequestDispatcher("/product.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
