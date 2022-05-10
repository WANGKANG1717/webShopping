<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ page import="java.util.Calendar" %>

<table border=0 cellpadding=0 cellspacing=0>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_01.gif" width=4></td>
        <td background=images/line_02.gif height=4></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_03.gif" width=4></td>
    </tr>
    <tr>
        <td background=images/line_04.gif></td>
        <td>
            <div id="left_login">
                <img src="images/vip_logo.png"/><br><br>
                <%
                    String userName = null;
                    if (session.getAttribute("user") != null)
                        userName = session.getAttribute("user").toString();
                    if (userName == null) {
                %>
                <form action="loginCheck" method="post">
                    <span class="zt1">用户名:</span>
                    <input type="text" name="username" class="input"><br><br>
                    <span class="zt1">密&nbsp;&nbsp;码:</span>
                    <input type="password" name="passwd" class="input"><br>
                    <a href="reg.jsp"><img src="images/reg_button.gif" border="0 "/></a>
                    <input name="imageField" type="image" src="images/login_button.gif"/>
                </form>
                <%
                } else {
                    byte a[] = userName.getBytes("ISO-8859-1");
                    userName = new String(a);
                    Calendar cal = Calendar.getInstance();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    if (hour >= 5 && hour < 8) {
                        out.print("<span style='color:red'>早上好!&nbsp;" + userName + "</span>");
                    } else if (hour >= 8 && hour < 11) {
                        out.print("<span style='color:red'>上午好!&nbsp;" + userName + "</span>");
                    } else if (hour >= 11 && hour < 13) {
                        out.print("<span style='color:red'>中午好!&nbsp;" + userName + "</span>");
                    } else if (hour >= 13 && hour < 18) {
                        out.print("<span style='color:red'>下午好!&nbsp;" + userName + "</span>");
                    } else if (hour >= 18 && hour < 23) {
                        out.print("<span style='color:red'>晚上好!&nbsp;" + userName + "</span>");
                    } else {
                        out.print("<span style='color:red'>夜深啦!&nbsp;" + userName + "</span>");
                    }
                %>
                <br><br>
                <form action="exit" method="post">
                    <input type="hidden" name="username" value="<%=session.getAttribute("user")%>">
                    <input type="submit" name="exit" value="退出">
                </form>

                <%
                    }
                %>

            </div>
        </td>
        <td background=images/line_05.gif>&nbsp;</td>
    </tr>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_06.gif" width=4></td>
        <td background=images/line_07.gif></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_08.gif" width=4></td>
    </tr>
</table>
<br>

<table border=0 cellpadding=0 cellspacing=0>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_01.gif" width=4></td>
        <td background=images/line_02.gif height=4></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_03.gif" width=4></td>
    </tr>
    <tr>
        <td background=images/line_04.gif></td>
        <td>
            <div id="left_sort">
                <img src="images/sort_logo.png"/><br><br>
                <div id="sort_menu">
                    <ul id="menu">
                        <li><img src="images/sort_menu.gif"/>&nbsp;&nbsp;
                            <a class="li_sort" href="getProduct?page=1&limit=6&category=日式女扇&method=post">
                                日式女扇</a></li>
                        <hr size="1"/>
                        <li><img src="images/sort_menu.gif"/>&nbsp;&nbsp;
                            <a class="li_sort" href="getProduct?page=1&limit=6&category=仿古男扇&method=post">仿古男扇</a></li>
                        <hr size="1"/>
                        <li><img src="images/sort_menu.gif"/>&nbsp;&nbsp;
                            <a class="li_sort" href="getProduct?page=1&limit=6&category=韩国扇&method=post">韩国扇</a>
                        </li>
                        <hr size="1"/>
                        <li><img src="images/sort_menu.gif"/>&nbsp;&nbsp;
                            <a class="li_sort" href="getProduct?page=1&limit=6&category=檀香扇&method=post">檀香扇</a>
                        </li>
                        <hr size="1"/>
                        <li><img src="images/sort_menu.gif"/>&nbsp;&nbsp;
                            <a class="li_sort" href="getProduct?page=1&limit=6&category=礼品广告扇&method=post">礼品广告扇</a></li>
                    </ul>
                </div>
            </div>

        </td>
        <td background=images/line_05.gif>&nbsp;</td>
    </tr>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_06.gif" width=4></td>
        <td background=images/line_07.gif></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_08.gif" width=4></td>
    </tr>
</table>
<br>

<table border=0 cellpadding=0 cellspacing=0>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_01.gif" width=4></td>
        <td background=images/line_02.gif height=4></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_03.gif" width=4></td>
    </tr>
    <tr>
        <td background=images/line_04.gif></td>
        <td>
            <div id="left_sort">
                <img src="images/contact_logo.png"/><br><br>
                <div id="sort_menu">
                    贝壳：
                    <a target="_blank"
                       href="https://kang17.xyz/about">
                        <img border="0"
                             src="http://amos.alicdn.com/online.aw?v=2&uid=lf5806388&site=cntaobao&s=1&charset=utf-8"
                             alt="点这里给我发消息"/>
                    </a>
                    <hr size="1"/>
                    Q我：
                    <a target="_blank" href="https://kang17.xyz/about">
                        <img border="0"
                             src="http://wpa.qq.com/pa?p=2:82178712:47"
                             alt="点击这里给我发消息"/>
                    </a>
                    <hr size="1"/>
                    手机：13082838117
                </div>
            </div>

        </td>
        <td background=images/line_05.gif>&nbsp;</td>
    </tr>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_06.gif" width=4></td>
        <td background=images/line_07.gif></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_08.gif" width=4></td>
    </tr>
</table>
<br>

<table border=0 cellpadding=0 cellspacing=0>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_01.gif" width=4></td>
        <td background=images/line_02.gif height=4></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_03.gif" width=4></td>
    </tr>
    <tr>
        <td background=images/line_04.gif></td>
        <td>
            <div id="left_sort">
                <img src="images/sale_logo.png"/><br><br>
                <div id="sale_sql_more"><a class="sql_more" href="getProduct?page=1&limit=6&category=&method=post">查看更多商品</a></div>
            </div>
        </td>
        <td background=images/line_05.gif>&nbsp;</td>
    </tr>
    <tr>
        <td valign=top width=4 height=4><img height=4 src="images/line_06.gif" width=4></td>
        <td background=images/line_07.gif></td>
        <td valign=top width=4 height=4><img height=4 src="images/line_08.gif" width=4></td>
    </tr>
</table>

