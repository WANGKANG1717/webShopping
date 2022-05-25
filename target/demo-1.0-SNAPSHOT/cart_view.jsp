<%@ page import="com.example.javaWeb.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>爱尚网扇品</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>

<div id="page">
    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div id="left_column">
        <jsp:include page="left_column.jsp"/>
    </div>
    <div id="center_column">
        <%!
            Double totalPrice = 0.0;
        %>
        <jsp:useBean id="user" scope="session" class="com.example.javaWeb.entity.User"/>
        <jsp:useBean id="shoppingCard" scope="session" class="java.util.ArrayList"/>
        <%
            if (user.getName() == null || user.getName().equals("")) { %>
        请先登录
        <% } else if (shoppingCard == null || shoppingCard.size() == 0) {
            totalPrice = 0.0;
        %>
        <div id="empty">
            <h3>您的购物车还是空的，</h3>
            <h3>赶紧行动吧！</h3>
        </div>
        <% } else { %>
        <img src="images/shopping_card.gif"/>
        <div id="cart_tb">
            <table style="width: 100%; text-align: center">
                <tr>
                    <td width="10%"><span style="color:#696969;font-size:13px;font-weight:bold;">序号</span></td>
                    <td width="30%"><span style="color:#696969;font-size:13px;font-weight:bold;">商品名称</span></td>
                    <td width="20%"><span style="color:#696969;font-size:13px;font-weight:bold;">单价（元）</span></td>
                    <td width="10%"><span style="color:#696969;font-size:13px;font-weight:bold;">数量</span></td>
                    <td width="10%"><span style="color:#696969;font-size:13px;font-weight:bold;">小计（元）</span></td>
                    <td width="20%"><span style="color:#696969;font-size:13px;font-weight:bold;">操作</span></td>
                </tr>
                <%
                    totalPrice = 0.0;
                    for (int i = 0; i < shoppingCard.size(); i++) {
                        Product product = (Product) shoppingCard.get(i); %>
                <tr>
                    <td><%=(i + 1)%>
                    </td>
                    <td><%=product.getName()%>
                    </td>
                    <td><%=product.getPro_price()%>
                    </td>
                    <td><%=product.getNum()%>
                    </td>
                    <td><%=product.getTotal_price()%>
                    </td>
                    <td>
                        <form method="post" action="shoppingCart" style="display: inline">
                            <input type="text" name="userID" value="<%=user.getId()%>" style="display: none">
                            <input type="text" name="productID" value="<%=product.getId()%>" style="display: none">
                            <input type="text" name="buyNum" value="-1" style="display: none">
                            <input type="text" name="method" value="add" style="display: none">
                            <% if (product.getNum() > 1) { %>
                            <input type="submit" value="-" style="width: 25px">
                            <% } else { %>
                            <input type="submit" disabled value="-" style="width: 25px">
                            <% } %>
                        </form>
                        <form method="post" action="shoppingCart" style="display: inline">
                            <input type="text" name="userID" value="<%=user.getId()%>" style="display: none">
                            <input type="text" name="productID" value="<%=product.getId()%>" style="display: none">
                            <input type="text" name="buyNum" value="1" style="display: none">
                            <input type="text" name="method" value="add" style="display: none">
                            <input type="submit" value="+" style="width: 25px">
                        </form>
                        <form method="post" action="shoppingCart" style="display: inline">
                            <input type="text" name="userID" value="<%=user.getId()%>" style="display: none">
                            <input type="text" name="productID" value="<%=product.getId()%>" style="display: none">
                            <input type="text" name="method" value="clearOne" style="display: none">
                            <input type="submit" value="删除">
                        </form>
                    </td>
                </tr>
                <% totalPrice += product.getTotal_price();
                }
                %>
            </table>
        </div>
        <div id="cart_tt">
            合计总金额：<span id="totalPrice" style="font-size:18px;color:#f60;"><%=totalPrice%></span>元</td>
        </div>
        <div id="cart_lk">
            <a href="index.jsp">继续购物</a> | <a href="#">去收银台结账</a> | <a
                href="shoppingCart?userID=<%=user.getId()%>&method=clearAll">清空购物车</a>
        </div>
        <% } %>
    </div>
    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>

</body>
</html>
