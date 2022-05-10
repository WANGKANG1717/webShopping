package com.example.javaWeb.servlet;

import com.example.javaWeb.Bean.User;
import com.example.javaWeb.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "RegCheck", value = "/RegCheck")
public class RegCheck extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String userName=request.getParameter("username");
        String passwd=request.getParameter("passwd");
        String passwd2=request.getParameter("passwd2");
        String sex=request.getParameter("sex");
        String[] hobby=request.getParameterValues("hobby");
//        System.out.println(hobby[0]);
        String msg="";
        if(userName==null || userName.equals("")) {
            msg+="userName_is_empty!<br>";
        }
        if(passwd==null || passwd.equals("")) {
            msg+="passwd_is_empty!<br>";
        }
        if(passwd2==null || passwd2.equals("")) {
            msg+="passwdconfirm_is_empty!<br>";
        }
        if(sex==null || sex.equals("")) {
            msg+="sex_is_empty!<br>";
        }
        if(hobby==null || hobby.equals("")) {
            msg+="hobby_is_empty!<br>";
        }
        if(passwd.equals(passwd2)!=true) {
            msg+="passwd_is_not_equal!<br>";
        }
        if(msg.equals("")==false) {
            request.setAttribute("outputMessage", msg);
            try {
                request.getRequestDispatcher("/reg.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            User.AddUser(userName, passwd,sex,hobby);
            msg="注册成功！";
            //跳转登录界面
            request.setAttribute("outputMessage", msg);
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
