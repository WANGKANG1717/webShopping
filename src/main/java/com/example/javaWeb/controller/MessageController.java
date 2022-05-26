package com.example.javaWeb.controller;

import com.example.javaWeb.entity.Message;
import com.example.javaWeb.service.MessageService;
import com.example.javaWeb.service.imp.MessageServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/11:23
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
@WebServlet(name = "message", value = "/message")
public class MessageController {
    MessageService messageService = new MessageServiceImp();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取参数识别用户想要请求的方法
         * 然后判断并调用对应的方法
         */
        String method = req.getParameter("method");
        if ("get".equals(method)) {
            getMessage(req, resp);
        }
    }

    public void getMessage(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getMessage");
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println(page +" " + limit);
        ArrayList<Message> messages = messageService.getMessages(page, limit);
        //
        Integer TotalNum = 0;
        if(messages.size()>0) {
            TotalNum = messages.get(0).getTotalNum();
        }
        //
        request.getSession().setAttribute("messages", messages);
        request.getSession().setAttribute("Page", page);
        request.getSession().setAttribute("TotalNum", TotalNum);    //产品的总数
        request.getSession().setAttribute("PageNum", TotalNum / limit + (TotalNum % limit != 0 ? 1 : 0));   //总的页数(向上取整)
        try {
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
