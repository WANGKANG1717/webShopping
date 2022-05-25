<%@ page import="com.example.javaWeb.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>爱尚网扇品</title>
    <link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all"/>
</head>
<body>
<jsp:useBean id="products" scope="session" class="java.util.ArrayList"/>
<%!
    Integer Page;
    Integer PageNum;
    Integer TotalNum;
    String keyword;
    String priceSelect;
    String salesSelect;
    String category;
    String getType = "getAllProduct";

    String outPriceSelect(String priceSelect) {
        String res = "";
        if (priceSelect != null && priceSelect.equals("price+")) {
            res = "<select name='priceSelect'>\n" +
                    "<option value=''></option>\n" +
                    "<option value='price+' selected>升序</option>\n" +
                    "<option value='price-'>降序</option>\n" +
                    "</select>";
        } else if (priceSelect != null && priceSelect.equals("price-")) {
            res = "<select name='priceSelect'>\n" +
                    "<option value=''></option>\n" +
                    "<option value='price+'>升序</option>\n" +
                    "<option value='price-' selected>降序</option>\n" +
                    "</select>";
        } else {
            res = "<select name='priceSelect'>\n" +
                    "<option value=''></option>\n" +
                    "<option value='price+'>升序</option>\n" +
                    "<option value='price-'>降序</option>\n" +
                    "</select>";
        }
        return res;
    }

    String outsalesSelect(String salesSelect) {
        String res = "";
        if (salesSelect != null && salesSelect.equals("sales+")) {
            res = "<select name='salesSelect'>\n" +
                    "<option value=''></option>\n" +
                    "<option value='sales+' selected>升序</option>\n" +
                    "<option value='sales-'>降序</option>\n" +
                    "</select>";
        } else if (salesSelect != null && salesSelect.equals("sales-")) {
            res = "<select name='salesSelect'>\n" +
                    "<option value=''></option>\n" +
                    "<option value='sales+'>升序</option>\n" +
                    "<option value='sales-' selected>降序</option>\n" +
                    "</select>";
        } else {
            res = "<select name='salesSelect'>\n" +
                    "<option value=''></option>\n" +
                    "<option value='sales+'>升序</option>\n" +
                    "<option value='sales-'>降序</option>\n" +
                    "</select>";
        }
        return res;
    }

    String outKeyword(String keyword) {
        if (keyword != null && !keyword.equals("")) {
            return "<input type='search' name='keyword' placeholder='请输入关键字' value=" + keyword + ">";
        } else {
            return "<input type='search' name='keyword' placeholder='请输入关键字' >";
        }
    }

    String UpPage(Integer Page, Integer PageNum, String getType) {
        String res = "<input type='button' value='上一页' disabled>";
        if (Page > 1) {
            if (getType == null || getType.equals("") || getType.equals("getAllProduct")) {
                res = "<form action='product' method='post' style='display:inline'>\n" +
                        "<input type='text' name='method' value='getAll' style='display:none'>\n" +
                        "<input type='text' name='page' value='" + (Page - 1) + "' style='display:none'>\n" +
                        "<input type='text' name='limit' value='6' style='display:none'>\n" +
                        "<input type='text' name='category' value='" + category + "' style='display:none'>\n" +
                        "<input type='submit' value='上一页'>\n" +
                        "</form>";
            } else if (getType.equals("searchProduct")) {
                res = "<form action='product' method='post' style='display: inline'>\n" +
                        "<input type='text' name='page' value='" + (Page - 1) + "' style='display:none'>\n" +
                        "<input type='text' name='limit' value='6' style='display:none'>\n" +
                        "<input type='text' name='method' value='search' style='display:none'>\n" +
                        "<input type='text' name='priceSelect' value='" + priceSelect + "' style='display:none'>\n" +
                        "<input type='text' name='salesSelect' value='" + salesSelect + "' style='display:none'>\n" +
                        "<input type='text' name='keyword' value='" + keyword + "' style='display: none'>\n" +
                        "<input type='submit' value='上一页'>\n" +
                        "</form>";
            }
        }
        return res;
    }

    String NextPage(Integer Page, Integer PageNum, String getType) {
        String res = "<input type='button' value='下一页' disabled>";
        if (Page < PageNum) {
            if (getType == null || getType.equals("") || getType.equals("getAllProduct")) {
                res = "<form action='product' method='post' style='display: inline'>\n" +
                        "<input type='text' name='method' value='getAll' style='display:none'>\n" +
                        "<input type='text' name='page' value='" + (Page + 1) + "' style='display:none'>\n" +
                        "<input type='text' name='limit' value='6' style='display:none'>\n" +
                        "<input type='text' name='category' value='" + category + "' style='display:none'>\n" +
                        "<input type='submit' value='下一页'>\n" +
                        "</form>";
            } else if (getType.equals("searchProduct")) {
                res = "<form action='product' method='post' style='display:inline'>\n" +
                        "<input type='text' name='page' value='" + (Page + 1) + "' style='display:none'>\n" +
                        "<input type='text' name='limit' value='6' style='display:none'>\n" +
                        "<input type='text' name='method' value='search' style='display:none'>\n" +
                        "<input type='text' name='priceSelect' value='" + priceSelect + "' style='display:none'>\n" +
                        "<input type='text' name='salesSelect' value='" + salesSelect + "' style='display:none'>\n" +
                        "<input type='text' name='keyword' value='" + keyword + "' style='display:none'>\n" +
                        "<input type='submit' value='下一页'>\n" +
                        "</form>";
            }
        }
        return res;
    }
%>
<%
    Page = (Integer) session.getAttribute("Page");
    PageNum = (Integer) session.getAttribute("PageNum");
    TotalNum = (Integer) session.getAttribute("TotalNum");
    keyword = (String) session.getAttribute("keyword");
    category = (String) session.getAttribute("category");
    priceSelect = (String) session.getAttribute("priceSelect");
    salesSelect = (String) session.getAttribute("salesSelect");
    getType = (String) session.getAttribute("getType");

    System.out.println(getType + " " + Page + " " + PageNum + " " + TotalNum + " " + priceSelect + " " + salesSelect + " " + keyword);
%>
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
                    <%=outPriceSelect(priceSelect)%>
                    </label><span style="margin-left: 30px"></span>
                    <label>销售量</label>
                    <%=outsalesSelect(salesSelect)%>
                    </label><span style="margin-left: 30px"></span>
                    <label>关键字</label>
                    <%=outKeyword(keyword)%>
                    <input type="submit" value="查询">
                </form>
            </div>
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
                    <li>
                        <p class='gprice'>原价：<span
                                style="color:#FF6600;font-weight:bold;"></span>￥
                            <del><%=product.getPrice()%>
                            </del>
                            元
                        </p>
                    </li>
                    <li><p class='gprice'>促销价：<span
                            style="color:#FF6600;font-weight:bold;">￥<%=product.getPro_price()%></span>元<br>
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
            <a class="pageLink">共<%=TotalNum%>产品</a>
            <a class="pageLink">共<%=PageNum%>页</a>
            <a class="pageLink">当前第<%=Page%>页</a>
            <%=UpPage(Page, PageNum, getType)%>
            <%=NextPage(Page, PageNum, getType)%>
        </div>
    </div>
    <div id="footer">
        <jsp:include page="bottom.jsp"/>
    </div>
</div>
</body>
</html>
