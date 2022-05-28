<%--
  Created by IntelliJ IDEA.
  User: WANGKANG
  Date: 2022/5/28
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.javaWeb.entity.Notice" %>
<%@ page import="com.example.javaWeb.entity.MessageInfo" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.example.javaWeb.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>留言详情</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>
<jsp:useBean id="messageInfoPair" scope="session" class="java.util.ArrayList"/>
<%!
    MessageInfo message;
    MessageInfo messageTo;
    String messageAddInfo;
%>
<%!
    String addZero(int a) {
        String p = "" + a;
        if (p.length() < 2) return "0" + p;
        else return p;
    }

    String printTime(LocalDateTime date) {
        return date.getYear() + "-" + addZero(date.getMonthValue()) + "-" + addZero(date.getDayOfMonth())
                + " " + addZero(date.getHour()) + ":" + addZero(date.getMinute()) + ":" + addZero(date.getSecond());
    }
%>
<%
    if (messageInfoPair.size() >= 2) {
        message = (MessageInfo) messageInfoPair.get(0);
        messageTo = (MessageInfo) messageInfoPair.get(1);
    } else if (messageInfoPair.size() == 1) {
        message = (MessageInfo) messageInfoPair.get(0);
        messageTo = null;
    }
    messageAddInfo = (String) session.getAttribute("messageAddInfo");
    System.out.println(messageAddInfo + " asdsdadsd");
%>
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
                留言详情
            </div>
            <div style="width: 100%; text-align: left;">
                <p class="test_p">留言人：<%=message.getUser().getName()%>
                </p>
                <p  class="test_p">留言时间：<label style="font: 15px bold;"><%=printTime(message.getMessage().getPtime())%>
                </label></p>
                <p class="test_p">留言内容：<br>
                <pre class="pre"><%=message.getMessage().getContent()%></pre>
                </p>
                <%
                    if (messageTo != null) { %>
                <div class="test_pp">
                    <p class="test_p" style="color: black">回复内容：</p>
                    <div style="margin-left: 15px">
                        <p>留言人：<%=messageTo.getUser().getName()%>
                        </p>
                        <p>留言时间：<label style="font: 15px bold;"><%=printTime(messageTo.getMessage().getPtime())%>
                        </label></p>
                        <p>留言内容：<br>
                        <pre class="pre"><%=messageTo.getMessage().getContent()%></pre>
                        </p>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>

</body>
</html>

<style>
    .test_p {
        word-wrap: break-word;
        word-break: normal;
        font-size: 17px;
    }

    .test_pp {
        word-wrap: break-word;
        word-break: normal;
        font-size: 14px;
        color: #ccc;
        margin-top: 25px;
    }

    .pre {
        font-size: 15px;
        margin-left: 25px;
    }
</style>
