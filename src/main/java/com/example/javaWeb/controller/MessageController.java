package com.example.javaWeb.controller;

import com.example.javaWeb.entity.MessageInfo;
import com.example.javaWeb.service.MessageService;
import com.example.javaWeb.service.imp.MessageServiceImp;
import javafx.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
public class MessageController extends HttpServlet {
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
        if ("getAll".equals(method)) {
            getMessages(req, resp);
        }
        else if("delete".equals(method)) {
            deleteMessage(req, resp);
        }
        else if("add".equals(method)) {
            addMessage(req, resp);
        }
    }

    public void getMessage(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getMessage");
        //
        String id = request.getParameter("id");
        ArrayList<MessageInfo> messageInfoPair = messageService.getMessagePair(id);
        //
        request.getSession().setAttribute("messageInfoPair", messageInfoPair);
        //移除上次的提交信息
        request.getSession().setAttribute("messageAddInfo", null);
        try {
            request.getRequestDispatcher("/message_view.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMessages(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getMessages");
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println(page +" " + limit);
        //
        ArrayList<MessageInfo> messageInfos = messageService.getMessages(page, limit);
        //
        Integer TotalNum = new Integer(0);
        if(messageInfos.size()>0) {
            TotalNum = messageInfos.get(0).getTotalNum();
        }
        request.getSession().setAttribute("messageInfos", messageInfos);
        request.getSession().setAttribute("Page", page);
        request.getSession().setAttribute("TotalNum", TotalNum);    //产品的总数
        request.getSession().setAttribute("PageNum", TotalNum / limit + (TotalNum % limit != 0 ? 1 : 0));   //总的页数(向上取整)
        try {
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMessage(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("deleteMessage");
        String id = request.getParameter("id");
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println(page +" " + limit);
        //
        boolean flag=messageService.deleteMessage(id);
        //
        ArrayList<MessageInfo> messageInfos = messageService.getMessages(page, limit);
        Integer TotalNum = new Integer(0);
        if(messageInfos.size()>0) {
            TotalNum = messageInfos.get(0).getTotalNum();
        }
        //
        request.getSession().setAttribute("messageInfos", messageInfos);
        request.getSession().setAttribute("Page", page);
        request.getSession().setAttribute("TotalNum", TotalNum);    //产品的总数
        request.getSession().setAttribute("PageNum", TotalNum / limit + (TotalNum % limit != 0 ? 1 : 0));   //总的页数(向上取整)

        try {
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMessage(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("addMessage");
        String userID = request.getParameter("userID");
        String mID = request.getParameter("mID");
        String msgContent = request.getParameter("msgContent");
        System.out.println(msgContent);
        boolean flag=messageService.addMessage(userID, mID, msgContent);
        //
        String messageAddInfo=(flag==true? "addSuccess" : "addFalse");
        request.getSession().setAttribute("messageAddInfo", messageAddInfo);
        try {
            request.getRequestDispatcher("/addMessage.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
