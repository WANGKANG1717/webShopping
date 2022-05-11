<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>

<body>
<div id="page">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div id="div_reg">
        <h3>会员登录</h3><br>
        <hr size=1>
        <div id="div_login">
            <div id="div_login_leftimg">
                <img src="images/boy.gif"/>
            </div>
            <div id="div_login_form">
                <form action="user" method="post">
                    <span class="zt2">
                        <%
                            String message=(String) request.getAttribute("outputMessage");
                            if(message!=null && !message.equals("")){
                                out.print(message);
                            }
                        %>
                    </span><br>
                    用户名:
                    <input type="text" name="username" class="input"><br><br>
                    密&nbsp;&nbsp;&nbsp;码:
                    <input type="password" name="passwd" class="input"><br><br>
                    <input name="imageField" type="image" src="images/login_button.gif"/>
                    <a href="reg.jsp"><img src="images/reg_button.gif" border="0 "/></a>
                    <input type="hidden" name="method" value="login"><br><br>
                </form>
            </div>
            <div id="div_login_rightimg">
                <img src="images/girl.gif"/>
            </div>
        </div>
    </div>
    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>
</body>

</html>
