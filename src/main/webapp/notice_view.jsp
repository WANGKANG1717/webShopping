<%--
  Created by IntelliJ IDEA.
  User: WANGKANG
  Date: 2022/5/25
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: WANGKANG
  Date: 2022/5/25
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.javaWeb.entity.Notice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商店公告</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>
<jsp:useBean id="notice" scope="session" class="com.example.javaWeb.entity.Notice"/>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div id="left_column">
        <jsp:include page="left_column.jsp"/>
    </div>
    <div id="center_column">
        <div style="width: 100%; text-align: center">
            <div style="font-family: 方正舒体; font: 35px bolder; width: 100%;">
                <%=notice.getName()%>
            </div>
            <div style="width: 100%;">
                <span style="margin-left: 150px"></span>
                <label style="font: 15px bold;"><%=notice.getPtime()%></label>
            </div>
            <div style="width: 100%; text-align: left;">
                <p style="word-wrap: break-word; word-break: normal;"><%=notice.getContent()%></p>
            </div>
        </div>
    </div>
    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>

</body>
</html>
