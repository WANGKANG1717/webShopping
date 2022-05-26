<%--
  Created by IntelliJ IDEA.
  User: WANGKANG
  Date: 2022/5/26
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.javaWeb.entity.Notice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在线留言</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>
<jsp:useBean id="notices" scope="session" class="java.util.ArrayList"/>
<%!
    Integer Page;
    Integer PageNum;
    Integer TotalNum;

    String UpPage(Integer Page) {
        String res = "<input type='button' value='上一页' disabled>";
        if (Page > 1) {
            res = "<form action='notice' method='post' style='display: inline'>\n" +
                    "<input type='text' name='page' value='" + (Page - 1) + "' style='display:none'>\n" +
                    "<input type='text' name='limit' value='20' style='display:none'>\n" +
                    "<input type='text' name='method' value='getAll' style='display:none'>\n" +
                    "<input type='submit' value='上一页'>\n" +
                    "</form>";
        }
        return res;
    }

    String NextPage(Integer Page, Integer PageNum) {
        String res = "<input type='button' value='下一页' disabled>";
        if (Page < PageNum) {
            res = "<form action='notice' method='post' style='display: inline'>\n" +
                    "<input type='text' name='page' value='" + (Page + 1) + "' style='display:none'>\n" +
                    "<input type='text' name='limit' value='20' style='display:none'>\n" +
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
        <table style="width: 100%; text-align: center">
            <tr>
                <th width="30%">通知名称</th>
                <th width="40%">通知内容</th>
                <th width="30%">通知时间</th>
            </tr>
            <%
                if (notices != null && notices.size() > 0) {
                    for (int i = 0; i < notices.size(); i++) {
                        Notice notice = (Notice) notices.get(i); %>
            <tr>
                <td>
                    <form action="notice" method="post">
                        <input type="hidden" name="method" value="get">
                        <input type="hidden" name="id" value="<%=notice.getId()%>">
                        <input type="submit" id="submit<%=notice.getId()%>" style="display: none">
                        <a class="li" style="width: 100%; cursor:pointer; display: inline" onclick="document.getElementById('submit<%=notice.getId()%>').click()">
                            <img src="images/dh_2.png" border="0"/>
                            <%=notice.getName()%></a>
                    </form>
                </td>
                <td style="max-width: 350px; overflow: hidden"><%=notice.getContent()%>
                </td>
                <td><%=notice.getPtime()%>
                </td>
            </tr>
            <%
                    }
                }
            %>
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
