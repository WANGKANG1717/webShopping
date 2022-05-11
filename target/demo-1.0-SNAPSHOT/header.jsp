<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<script>
    function openWin(url, width, height) {
        var phxWin = window.open(url, '', 'width=' + width + ',height=' + height + ',left=' + (screen.width - width) / 2 + ',top=' + (screen.height - height) / 2 + '');
    }
</script>

<div id="logo">
    <a href="#"><img src="images/logo.png" border="0"/></a>
</div>

<div id="header_right">
    <jsp:useBean id="user" scope="session" class="com.example.javaWeb.Bean.User"/>
    <%
        String userName = null;
        if (user != null)
            userName = user.getName();
        if (userName == null || userName.equals("")) {
    %>
    欢迎光临，<a href="reg.jsp">注册</a>/<a href="login.jsp">登陆</a>
    <%
        } else {
            byte a[] = userName.getBytes("ISO-8859-1");
            userName = new String(a);
            out.print("" + userName + "，<span style='color:red'>欢迎光临!</span>");
        }
    %>
    <br>
    <img src="images/chat.png"/>&nbsp;<a target="_blank" href="https://kang17.xyz" style="cursor:hand">联系我们</a> <img
        src="images/order.png"/>&nbsp;<a href="addShoppingCart?userID=<%=user.getId()%>">购物车</a>
</div>

<div id="headermenu">
    <ul id="menu">
        <li>
            <a class="li" href="index.jsp"><img src="images/dh_1.png" border="0 "/>&nbsp;首页</a>
        </li>
        <li>
            <a class="li" href="#"><img src="images/dh_2.png" border="0 "/>&nbsp;商店公告</a>
        </li>
        <li>
            <form action="getProduct" method="post" name="Products">
                <input type="hidden" name="method" value="post">
                <input type="hidden" name="page" value="1">
                <input type="hidden" name="limit" value="6">
                <input type="hidden" name="category" value="">
                <a class="li" href="javascript:document.Products.submit()"><img src="images/dh_3.png" border="0 "/>&nbsp;全部商品</a>
            </form>
        </li>
        <li>
            <a class="li" href="#"><img src="images/dh_4.png" border="0 "/>&nbsp;付款方式</a>
        </li>

        <li>
            <a class="li" href="#"><img src="images/dh_5.png" border="0 "/>&nbsp;关于我们</a>
        </li>

        <li>
            <a class="li" href="#"><img src="images/dh_6.png" border="0 "/>&nbsp;在线留言</a>
        </li>
    </ul>
</div>

<div id="search">
    <form id="form1" name="search" method="post" action="#">
        <input type="text" name="textfield" style="color:#a4a4a4;vertical-align:middle;" value="请输入关键字"
               onfocus="this.value=''"/>&nbsp
        <input name="imageField" type="image" align="absmiddle" src="images/search.gif"/>
    </form>
</div>
