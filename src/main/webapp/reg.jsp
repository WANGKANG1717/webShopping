<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div id="div_reg">
        <h3>注册新用户</h3><br>
        <hr size=1>
        <span class="zt2">
            <%
                String message = (String) request.getAttribute("outputMessage");
                if (message != null && !message.equals("")) {
                    out.print(message);
                }
            %>
        </span><br>
<%--        accept-charset="UTF-8"--%>
        <form action="user" method="post">
            <table align="center">
                <tr>
                    <td>用户名：
                    </td>
                    <td><input type="text" name="username">
                    </td>
                </tr>
                <tr>
                    <td>密码：
                    </td>
                    <td><input type="password" name="passwd">
                    </td>
                </tr>
                <tr>
                    <td>确认密码：
                    </td>
                    <td><input type="password" name="passwd2">
                    </td>
                </tr>
                <tr>
                    <td>性别：
                    </td>
                    <td>
                        <input type="radio" name="sex" value="男">男
                        <input type="radio" name="sex" value="女">女
                    </td>
                </tr>
                <tr>
                    <td>兴趣：
                    </td>
                    <td>
                        <input type="checkbox" name="hobby" value="爬山">爬山
                        <input type="checkbox" name="hobby" value="钓鱼">钓鱼
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册">
                    </td>
                    <td><input type="reset" value="重置">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="method" value="register"><br><br>
        </form>

    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>
</body>
</html>
