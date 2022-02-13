<%@ page import="com.example.finalproject.model.entity.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 11.02.2022
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../header/header.jsp" %>
<%
    List<Order> ordersList = (List<Order>) (request.getAttribute("butler_orders"));
%>
<% for (int i = 0; i < ordersList.size(); ++i) { %>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Start date</th>
        <th scope="col">Finish date</th>
        <th scope="col">Total price</th>
    </tr>
    </thead>
    <tbody>
    <td><%=ordersList.get(i).getStartDate()%>
    </td>
    <td><%=ordersList.get(i).getFinishDate()%>
    </td>
    <td><%=ordersList.get(i).getTotalPrice()%>
    </td>
    </tbody>
</table>
</form>
<%} %>
<%@include file="../../footer/footer.jsp" %>
</body>
</html>
