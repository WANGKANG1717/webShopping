package com.example.javaWeb.controller;

import com.example.javaWeb.entity.Notice;
import com.example.javaWeb.service.NoticeService;
import com.example.javaWeb.service.NoticeService;
import com.example.javaWeb.service.imp.NoticeServiceImp;
import com.example.javaWeb.service.imp.NoticeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/25/16:05
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
@WebServlet(name = "notice", value = "/notice")
public class NoticeController extends HttpServlet {
    NoticeService noticeService = new NoticeServiceImp();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取参数识别用户想要请求的方法
         * 然后判断并调用对应的方法
         */
        String method = req.getParameter("method");
        if ("get".equals(method)) {
            getNotice(req, resp);
        } else if ("getAll".equals(method)) {
            getAllNotice(req, resp);
        }
    }

    public void getNotice(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getNotice");
        String id = request.getParameter("id");
        Notice notice = noticeService.getNotice(id);
        System.out.println(id+ "id Notice");
        request.getSession().setAttribute("notice", notice);
        try {
            request.getRequestDispatcher("/notice_view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAllNotice(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("getNotice");
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println(page +" " + limit);
        ArrayList<Notice> notices = noticeService.getNotices(page, limit);
        //
        Integer TotalNum = new Integer(0);
        if(notices.size()>0) {
            TotalNum = notices.get(0).getTotalNum();
        }
        //
        request.getSession().setAttribute("notices", notices);
        request.getSession().setAttribute("Page", page);
        request.getSession().setAttribute("TotalNum", TotalNum);    //产品的总数
        request.getSession().setAttribute("PageNum", TotalNum / limit + (TotalNum % limit != 0 ? 1 : 0));   //总的页数(向上取整)
        try {
            request.getRequestDispatcher("/notice.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
