<%--
  Created by IntelliJ IDEA.
  User: WANGKANG
  Date: 2022/5/27
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在线留言</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>
<jsp:useBean id="user" scope="session" class="com.example.javaWeb.entity.User"/>
<jsp:useBean id="messageAddInfo" scope="session" class="java.lang.String"/>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div id="left_column">
        <jsp:include page="left_column.jsp"/>
    </div>

    <div id="center_column">
        <div style="width: 100%; text-align: center; font-family: 微软雅黑; font: 30px bold">请留言🙌👌👍</div>
        <%
            if (user == null || user.getName() == null || user.getName().equals("")) { %>
        请先登录
        <% } else {
                System.out.print(messageAddInfo+"dadsd");
            if (messageAddInfo != null && !messageAddInfo.equals("")) {
                if(messageAddInfo.equals("addSuccess")) {
                    out.print("恭喜，留言成功，请返回。");
                }
                else if(messageAddInfo.equals("addFalse")) {
                    out.print("留言失败,请重试！");
                }
            } else {
        %>
            <form action="message" method="post">
                <input type="text" name="method" value="add" style="display: none">
                <input type="text" name="userID" value="<%=user.getId()%>" style="display: none">
                <textarea name="msgContent" cols="93" rows="25" style="font-size: 15px; padding: 10px"></textarea>
                <input type="submit" value="提交" style="float:right; margin-top: 10px">
            </form>
        <% }} %>
    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>

</body>
</html>
