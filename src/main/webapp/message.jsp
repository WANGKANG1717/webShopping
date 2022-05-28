<%--
  Created by IntelliJ IDEA.
  User: WANGKANG
  Date: 2022/5/26
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.javaWeb.entity.MessageInfo" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.example.javaWeb.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在线留言</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>
<jsp:useBean id="messageInfos" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="user" scope="session" class="com.example.javaWeb.entity.User"/>
<%!
    String addZero(int a) {
        String p=""+a;
        if(p.length()<2) return "0"+p;
        else return p;
    }
    String printTime(LocalDateTime date) {
        return date.getYear() + "-" + addZero(date.getMonthValue()) + "-" + addZero(date.getDayOfMonth())
                + " " + addZero(date.getHour()) + ":" + addZero(date.getMinute()) + ":" + addZero(date.getSecond());
    }
    boolean Judge(User a, User b) {
        if(a==null || b==null) return false;
        if(a.getName().equals("") || b.getName().equals("")) return false;
        return a.equals(b);
    }
%>

<%!
    Integer Page;
    Integer PageNum;
    Integer TotalNum;

    String UpPage(Integer Page) {
        String res = "<input type='button' value='上一页' disabled>";
        if (Page > 1) {
            res = "<form action='message' method='post' style='display: inline'>\n" +
                    "<input type='text' name='page' value='" + (Page - 1) + "' style='display:none'>\n" +
                    "<input type='text' name='limit' value='25' style='display:none'>\n" +
                    "<input type='text' name='method' value='getAll' style='display:none'>\n" +
                    "<input type='submit' value='上一页'>\n" +
                    "</form>";
        }
        return res;
    }

    String NextPage(Integer Page, Integer PageNum) {
        String res = "<input type='button' value='下一页' disabled>";
        if (Page < PageNum) {
            res = "<form action='message' method='post' style='display: inline'>\n" +
                    "<input type='text' name='page' value='" + (Page + 1) + "' style='display:none'>\n" +
                    "<input type='text' name='limit' value='25' style='display:none'>\n" +
                    "<input type='text' name='method' value='getAll' style='display:none'>\n" +
                    "<input type='submit' value='下一页'>\n" +
                    "</form>";
        }
        return res;
    }
%>
<%
    Page = (Integer) session.getAttribute("Page");
    PageNum = (Integer) session.getAttribute("PageNum");
    TotalNum = (Integer) session.getAttribute("TotalNum");

    System.out.println(Page + " " + PageNum + " " + TotalNum);
%>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>
    <div id="left_column">
        <jsp:include page="left_column.jsp"/>
    </div>
    <div id="center_column">
        <div style="width: 100%; text-align: center; font-family: 微软雅黑; font: 30px bold">欢迎留言🙌👌👍</div>
        <div style="font-size: 20px; margin-bottom: 10px;">
            <a href="addMessage.jsp" style="text-decoration-line: none">发布留言</a>
        </div>
        <table style="width: 100%; text-align: center">
            <tr>
                <th width="5%">ID</th>
                <th width="10%">留言人</th>
                <th width="40%">留言内容</th>
                <th width="20%">留言时间</th>
                <th width="20%">操作</th>
            </tr>
            <%
                for (int i = 0; i < messageInfos.size(); i++) {
                    MessageInfo messageInfo = (MessageInfo) messageInfos.get(i);
            %>
            <tr>
                <td><%=(i + 1)%>
                </td>
                <td><%=messageInfo.getUser().getName()%>
                </td>
                <td style="max-width: 350px; overflow: hidden"><%=messageInfo.getMessage().getContent()%>
                </td>
                <td style="font-size: 5px"><%=printTime(messageInfo.getMessage().getPtime())%>
                </td>
                <td style="font-size: 8px">
                    <%
                        if(user==null || user.getName()==null || user.getName().equals("")) { %>
                            请先登录
                    <%} else {%>
                    <%
                        if (Judge(user, messageInfo.getUser())) { %>
                        <form action="message" method="post" style="display: inline">
                            <input type="text" name="method" value="delete" style="display: none">
                            <input type="text" name="id" value="<%=messageInfo.getMessage().getId()%>" style="display: none">
                            <input type="text" name="page" value="<%=Page%>" style="display: none">
                            <input type="text" name="limit" value="25" style="display: none">
                            <input type="submit" value="删除">
                        </form>
                    <%}%>

                    <form action="message" method="post" style="display: inline">
                        <input type="text" name="method" value="get" style="display: none">
                        <input type="text" name="id" value="<%=messageInfo.getMessage().getId()%>" style="display: none">
                        <input type="submit" value="详情">
                    </form>
                </td>
            </tr>
            <% }} %>
        </table>

        <div id='page_next'>
            <a class="pageLink">共<%=TotalNum%>条</a>
            <a class="pageLink">共<%=PageNum%>页</a>
            <a class="pageLink">当前第<%=Page%>页</a>
            <%=UpPage(Page)%>
            <%=NextPage(Page, PageNum)%>
        </div>
    </div>
    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>

</body>
</html>
