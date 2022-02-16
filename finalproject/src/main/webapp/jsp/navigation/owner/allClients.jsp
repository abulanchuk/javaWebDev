<%@ page import="com.example.finalproject.model.entity.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 13.02.2022
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Client's list</title>
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
    List<Client> clientsList = (List<Client>) (request.getAttribute("clients_list"));
%>


<table class="table">
    <thead>
    <tr>
        <th scope="col">Client's name</th>
        <th scope="col">Client's surname</th>
        <th scope="col">Email</th>
        <th scope="col">Passport number</th>
        <th scope="col">Bank Account</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < clientsList.size(); ++i) { %>
    <tr>
        <td><%=clientsList.get(i).getName()%>
        </td>
        <td><%=clientsList.get(i).getSurname()%>
        </td>
        <td><%=clientsList.get(i).getEmail()%>
        </td>
        <td><%=clientsList.get(i).getPasswordNumber()%>
        </td>
        <td><%=clientsList.get(i).getBankAccount()%>
        </td>
    </tr>
    </tbody>
</table>
</form>
<%} %>

<%@include file="../../footer/footer.jsp" %>
</body>
</html>
