<%@ page import="com.example.finalproject.model.entity.Butler" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 13.02.2022
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List of butlers</title>
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
    List<Butler> butlersList = (List<Butler>) (request.getAttribute("butlers_list"));
%>


<table class="table">
    <thead>
    <tr>
        <th scope="col">Butler's name</th>
        <th scope="col">Butler's surname</th>
        <th scope="col">Rating</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < butlersList.size(); ++i) { %>
    <tr>
        <td><%=butlersList.get(i).getName()%>
        </td>
        <td><%=butlersList.get(i).getSurname()%>
        </td>
        <td><%=butlersList.get(i).getRating()%>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>
</form>

<%@include file="../../footer/footer.jsp" %>
</body>
</html>
