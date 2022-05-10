<%@ page import="com.example.javaWeb.Bean.Product" %>
<%@ page language="java" contentType="text/html; charset=GB2312"
		 pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>爱尚网扇品</title>
<link rel="stylesheet" rev="stylesheet" href="css/global.css" type="text/css" media="all" />
</head>
<body>

		<div id="page">
			<div id="header">
				<jsp:include page="header.jsp" />
       		</div>

			<div id="left_column">
				<jsp:include page="left_column.jsp" />
			</div>
			<div id="center_column">
				<%!
					Double totalPrice=0.0;
				%>
				 <%
					 if(session.getAttribute("shoppingCard")==null){
					 	totalPrice=0.0;
				 %>
					<div id="empty">
						<h3>您的购物车还是空的，</h3>
						<h3>赶紧行动吧！</h3>
					</div>
				<%
					 }
					 else{
				%>
				<img src="images/shopping_card.gif" />
				<div id="cart_tb">
						<table style="width: 100%">
							<tr>
								<td width="10%"><span style="color:#696969;font-size:13px;font-weight:bold;">序号</span></td>
								<td width="30%"><span style="color:#696969;font-size:13px;font-weight:bold;">商品名称</span></td>
								<td width="20%"><span style="color:#696969;font-size:13px;font-weight:bold;">单价（元）</span></td>
								<td width="20%"><span style="color:#696969;font-size:13px;font-weight:bold;">数量</span></td>
								<td width="20%"><span style="color:#696969;font-size:13px;font-weight:bold;">小计（元）</span></td>
							</tr>
							<jsp:useBean id="shoppingCard" scope="session" class="java.util.ArrayList"/>
							<%
								totalPrice=0.0;
								for(int i=0; i<shoppingCard.size(); i++) {
									Product product = (Product) shoppingCard.get(i);
									out.print("<tr>\n" +
											"\t\t\t\t\t\t\t\t<td>"+(i+1)+"</td>\n" +
											"\t\t\t\t\t\t\t\t<td>"+product.getName()+"</td>\n" +
											"\t\t\t\t\t\t\t\t<td>"+product.getPro_price()+"</td>\n" +
											"\t\t\t\t\t\t\t\t<td>"+product.getNum()+"</td>\n" +
											"\t\t\t\t\t\t\t\t<td>"+product.getTotal_price()+"</td></tr>");
									totalPrice+=product.getTotal_price();
								}
							%>
						</table>
					</div>
				<%
					}
				%>
				<div id="cart_tt">
					合计总金额：<span id="totalPrice" style="font-size:18px;color:#f60;"><%=totalPrice%></span>元</td>
				</div>
				<div id="cart_lk">
					<a href="index.jsp">继续购物</a> | <a href="#">去收银台结账</a> | <a href="cart_remove.jsp">清空购物车</a>
				</div>

			</div>
			<div id="footer">
				<jsp:include page="bottom.jsp" />
			</div>
		</div>

</body>
</html>
