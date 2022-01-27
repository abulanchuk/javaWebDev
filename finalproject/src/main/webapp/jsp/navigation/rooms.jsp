<%@ page import="java.util.List" %>
<%@ page import="com.example.finalproject.model.entity.Room" %><%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 22.01.2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="bundle/locale"/>

<fmt:message key="rooms.makeReservation" var="Reservation"/>
<fmt:message key="rooms.price" var="Price"/>

<html>
<head>
    <title>Rooms</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/rooms.css" type="text/css">
</head>
<body>
<%@include file="../header/header.jsp" %>

<%
    List<Room> roomsAvailable = (List<Room>) (request.getAttribute("catalog"));
%>

<% for (int i = 0; i < roomsAvailable.size(); ++i) { %>
<div class="card mb-3">
    <div class="row g-0">
        <div class="col-md-8">
            <img src="${pageContext.request.contextPath}<%=roomsAvailable.get(i).getImageUrl()%>"
                 class="img-fluid rounded-start w-100" alt="номера на мальдивах">
        </div>
        <div class="col-md-4">
            <div class="card-body">
                <h5 class="card-title"><%=roomsAvailable.get(i).getRoomType()%>
                </h5>
                <p class="card-text">${Price}: <%=roomsAvailable.get(i).getPrice() + " $"%>
                </p>

                <c:choose>
                    <c:when test="${sessionScope.authorization}">

                        <li class=" nav-item">
                            <button class="btn btn-secondary btn-lg px-5" type="submit">${Reservation}
                            </button>
                        </li>

                    </c:when>
                    <c:otherwise>
                        <li class=" nav-item">
                            <button class="btn btn-secondary btn-lg px-5"
                                    onclick="document.location='${pageContext.request.contextPath}/jsp/navigation/authorization.jsp'">
                                    ${Reservation}
                            </button>
                        </li>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </div>
</div>

<%} %>

<%@include file="../footer/footer.jsp" %>
</body>
</html>
