<%@ page import="com.example.javaWeb.entity.Product" %>
<%@ page import="com.mysql.cj.Session" %>
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
        <div class="divBorder">
            <img src="images/all_fans.gif"/><br>
            <div style="width: 100%; margin-top: 5px">
                <form action="product" method="post">
                    <input type="text" name="page" value="1" style="display: none">
                    <input type="text" name="limit" value="6" style="display: none">
                    <input type="text" name="method" value="search" style="display: none">
                    <label style="font-size: large">筛选
                    </label><span style="margin-left: 50px"></span>
                    <label>价格</label>
                    <select name="price">
                        <option value="price+">升序</option>
                        <option value="price-">降序</option>
                    </select>
                    </label><span style="margin-left: 30px"></span>
                    <label>销售量</label>
                    <select name="sales">
                        <option value="sales+">升序</option>
                        <option value="sales-">降序</option>
                    </select>
                    </label><span style="margin-left: 30px"></span>
                    <label>关键字</label>
                    <input type="search" name="keyword" placeholder="请输入关键字" value="">
                    <input type="submit" value="查询">
                </form>
            </div>
            <jsp:useBean id="products" scope="session" class="java.util.ArrayList"/>
            <%
                if (products != null && products.size() > 0) {
                    for (int i = 0; i < products.size(); i++) {
                        Product product = (Product) products.get(i); %>
            <div id='sort_product'>
                <ul>
                    <li>
                        <p class='gpic'><a href='product?id=<%=product.getId()%>&method=get'>
                            <img width='205px' height='154px' src="Picture/<%=product.getImg()%>"></a></p>
                    </li>
                    <li>
                        <p class='gbt'><a href='product?id=<%=product.getId()%>&method=get'>品名；<%=product.getName()%>
                        </a></p>
                    </li>
                    <li><p class='gprice'>促销价：<span
                            style="color:#FF6600;font-weight:bold;"></span>￥<%=product.getPrice()%>元</p>
                    </li>
                    <li><p class='gsale'>已售出：<span style='font-weight:bold;'><%=product.getSales()%></span>&nbsp;笔</p>
                    </li>
                </ul>
            </div>
            <%
                    }
                }
            %>
        </div>
        <%--        实现分页跳转，并且对分页进行限制--%>
        <div id='page_next'>
            <a class="pageLink">共<%=session.getAttribute("TotalNUm")%>产品</a>
            <a class="pageLink">共<%=session.getAttribute("PageNum")%>页</a>
            <a class="pageLink">当前第<%=session.getAttribute("page")%>页</a>
            <%
                Integer currentPage = (Integer) session.getAttribute("page");
                Integer totalPage = (Integer) session.getAttribute("PageNum");
                if (currentPage > 1) { %>
            <a class="pageLink"
               href="product?page=<%=(Integer) session.getAttribute("page")-1%>&limit=6&category=<%=session.getAttribute("category")%>&method=getAll">上一页</a>
            <% } else { %>
            <a class="pageLink">上一页</a>
            <% }
                if (currentPage < totalPage) { %>
            <a class="pageLink"
               href="product?page=<%=(Integer) session.getAttribute("page")+1%>&limit=6&category=<%=session.getAttribute("category")%>&method=getAll">下一页</a>
            <% } else { %>
            <a class="pageLink">下一页</a>
            <% } %>
        </div>
    </div>
    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>
</body>
</html>
