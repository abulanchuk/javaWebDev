<%@ page import="com.example.finalproject.model.entity.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 08.02.2022
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="current_page" value="${pageContext.request.requestURI}" scope="session"/>
<html>
<head>
    <title>Show orders</title>
    <script type="text/javascript">
        function disableBack() {
            window.history.forward();
        }

        setTimeout("disableBack()", 0);
        window.onunload = function () {
            null
        };
    </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>
</head>
<body>
<%@include file="../../header/header.jsp" %>

<%
    List<Order> orderList = (List<Order>) (request.getAttribute("orders"));
%>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID butler</th>
        <th scope="col">Start date</th>
        <th scope="col">Leave date date</th>
        <th scope="col">Total price</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < orderList.size(); ++i) { %>
    <tr>
        <td><%=orderList.get(i).getIdButler()%>
        </td>
        <td><%=orderList.get(i).getStartDate()%>
        </td>
        <td><%=orderList.get(i).getFinishDate()%>
        </td>
        <td><%=orderList.get(i).getTotalPrice()%>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>

<%@include file="../../footer/footer.jsp" %>
</body>
</html>
