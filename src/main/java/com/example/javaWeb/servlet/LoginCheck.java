package com.example.javaWeb.servlet;

import com.example.javaWeb.Bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginCheck", value = "/loginCheck")
public class LoginCheck extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("username");
        String passwd = request.getParameter("passwd");
//        System.out.println(userName+passwd);
        String info = null;
        /**
         * 本来偷懒使用username
         * 后来发现太不方便了，还是传回user信息把
         */
        User user = User.Login(userName, passwd);
        if (user!=null) {
            info = "Success";
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {
            info = "用户名或密码错误";
            System.out.println("验证失败");
        }
        request.setAttribute("outputMessage", info);
        try {
            if (info.equals("Success")) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
