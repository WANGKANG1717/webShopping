<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    function openWin(url, width, height) {
        var phxWin = window.open(url, '', 'width=' + width + ',height=' + height + ',left=' + (screen.width - width) / 2 + ',top=' + (screen.height - height) / 2 + '');
    }
</script>

<div id="logo">
    <a href="#"><img src="images/logo.png" border="0"/></a>
</div>

<div id="header_right">
    <jsp:useBean id="user" scope="session" class="com.example.javaWeb.entity.User"/>
    <%
        String userName = null;
        if (user != null)
            userName = user.getName();
        if (userName == null || userName.equals("")) {
    %>
    欢迎光临，<a href="reg.jsp">注册</a>/<a href="login.jsp">登陆</a>
    <%
        } else {
            byte a[] = userName.getBytes("utf-8");
            userName = new String(a);
            out.print("" + userName + "，<span style='color:red'>欢迎光临!</span>");
        }
    %>
    <br>
    <img src="images/chat.png"/>&nbsp;<a target="_blank" href="https://kang17.xyz" style="cursor:hand">联系我们</a> <img
        src="images/order.png"/>&nbsp;<a href="shoppingCart?userID=<%=user.getId()%>&method=get">购物车</a>
</div>

<div id="headermenu">
    <ul id="menu">
        <li>
            <a class="li" href="index.jsp"><img src="images/dh_1.png" border="0 "/>&nbsp;首页</a>
        </li>
        <li>
            <form action="notice" method="post" name="getAllNotice">
                <input type="hidden" name="method" value="getAll">
                <input type="hidden" name="page" value="1">
                <input type="hidden" name="limit" value="20">
                <a class="li" href="javascript:document.getAllNotice.submit()"><img src="images/dh_2.png" border="0"/>&nbsp;商店公告</a>
            </form>
        </li>
        <li>
            <form action="product" method="post" name="getAllProduct">
                <input type="hidden" name="method" value="getAll">
                <input type="hidden" name="page" value="1">
                <input type="hidden" name="limit" value="6">
                <input type="hidden" name="category" value="">
                <a class="li" href="javascript:document.getAllProduct.submit()"><img src="images/dh_3.png" border="0 "/>&nbsp;全部商品</a>
            </form>
        </li>
        <li>
            <a class="li" href="#"><img src="images/dh_4.png" border="0 "/>&nbsp;付款方式</a>
        </li>

        <li>
            <a class="li" href="https://kang17.xyz" target="_blank"><img src="images/dh_5.png" border="0 "/>&nbsp;关于我们</a>
        </li>

        <li>
            <a class="li" href="#"><img src="images/dh_6.png" border="0 "/>&nbsp;在线留言</a>
        </li>
    </ul>
</div>

<div id="search">
    <form action='product' method='post'>
        <input type='text' name='page' value='1' style='display:none'>
        <input type='text' name='limit' value='6' style='display:none'>
        <input type='text' name='method' value='search' style='display:none'>
        <input type='text' name='priceSelect' value='' style='display:none'>
        <input type='text' name='salesSelect' value='' style='display:none'>
        <input type='text' name='keyword' placeholder='请输入关键字'>
        <input type='submit' value='搜索'>
    </form>
</div>
