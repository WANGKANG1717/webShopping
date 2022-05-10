<%@ page import="com.example.javaWeb.Bean.Product" %><%--
  Created by IntelliJ IDEA.
  User: WANGKANG
  Date: 2022/4/20
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testProduct</title>
</head>
<body>
<%--<form action="getProduct" method="get">--%>
<%--    <input type="text" value="1" name="id">--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
<%--<jsp:useBean id="product" scope="session" class="com.example.javaWeb.Bean.Product"/>--%>
<%--<jsp:getProperty name="product" property="id"/><br>--%>
<%--<jsp:getProperty name="product" property="name"/><br>--%>
<%--<jsp:getProperty name="product" property="price"/><br>--%>
<%--<jsp:getProperty name="product" property="inventory"/><br>--%>
<%--<jsp:getProperty name="product" property="sales"/><br>--%>
<%--<jsp:getProperty name="product" property="img"/><br>--%>
<%--<jsp:getProperty name="product" property="category"/><br>--%>
<%--<jsp:getProperty name="product" property="fan_material"/><br>--%>
<%--<jsp:getProperty name="product" property="fan_bone_material"/><br>--%>
<%--<jsp:getProperty name="product" property="fan_bone_num"/><br>--%>
<%--<jsp:getProperty name="product" property="fan_bone_length"/><br>--%>
<%--<form action="getNewProduct" method="post">--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
<jsp:forward page="getNewProduct"></jsp:forward>
<jsp:useBean id="newProducts" scope="session" class="java.util.ArrayList"/>
<%
    for(int i=0; i<newProducts.size(); i++) {
        Product product=(Product) newProducts.get(i);
        out.print(product.getId()+"<br>");
    }
%>
</body>
</html>
