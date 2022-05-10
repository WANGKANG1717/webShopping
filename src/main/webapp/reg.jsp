<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
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
        <form action="RegCheck" method="post">
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
        </form>

    </div>

    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>
</body>
</html>
