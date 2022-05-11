<%@ page import="com.example.javaWeb.Bean.Product" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
            <jsp:useBean id="products" scope="session" class="java.util.ArrayList"/>
            <%
                if(products!=null && products.size()>0) {
                    for (int i = 0; i < products.size(); i++) {
                        Product product = (Product) products.get(i);
                        out.print("<div id='sort_product'>\n" +
                                "\t\t\t\t\t<ul>\n" +
                                "\t\t\t\t\t\t<li><p class='gpic'><a href='getProduct?id=" + product.getId() + "&method=get'><img width='205px' height='154px' src=\"Picture/" + product.getImg() + "\"></a></p></li>\n" +
                                "\t\t\t\t\t\t<li><p class='gbt'><a href='getProduct?id=" + product.getId() + "&method=get'>品名；" + product.getName() + " </a></p></li>\n" +
                                "\t\t\t\t\t\t<li><p class='gprice'>促销价：<span style=\"color:#FF6600;font-weight:bold;\"></span>￥" + product.getPrice() + "元</p></li>\n" +
                                "\t\t\t\t\t\t<li><p class='gsale'>已售出：<span style='font-weight:bold;'>" + product.getSales() + "</span>&nbsp;笔</p></li>\n" +
                                "\t\t\t\t\t</ul>\n" +
                                "\t\t\t\t</div>");
                    }
                }
            %>
        </div>
<%--        实现分页跳转，并且对分页进行限制--%>
        <div id='page_next'>
            <a class="pageLink">共<%=session.getAttribute("TotalNUm")%>产品</a>
            <a class="pageLink">第<%=session.getAttribute("PageNum")%>页</a>
            <a class="pageLink">当前第<%=session.getAttribute("page")%>页</a>
            <%
                Integer currentPage=(Integer) session.getAttribute("page");
                Integer totalPage=(Integer) session.getAttribute("PageNum");
                if(currentPage>1) { %>
                    <a class="pageLink" href="getProduct?page=<%=(Integer) session.getAttribute("page")-1%>&limit=6&category=<%=session.getAttribute("category")%>&method=post">上一页</a>
               <% } else { %>
                    <a class="pageLink">上一页</a>
               <% }
                if(currentPage<totalPage) { %>
                    <a class="pageLink" href="getProduct?page=<%=(Integer) session.getAttribute("page")+1%>&limit=6&category=<%=session.getAttribute("category")%>&method=post">下一页</a>
               <% }else { %>
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
