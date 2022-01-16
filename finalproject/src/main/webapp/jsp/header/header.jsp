<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 10.01.2022
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" type="text/css">
</head>

<body>
<nav class="navbar navbar-expand-md">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/jsp/navigation/main.jsp">
        <img src="${pageContext.request.contextPath}/images/main_logo.svg" width="200" height="110"
             alt="logo hotel"/></a>
    <p><a href="https://www.tripadvisor.com/Hotel_Review-g14991100-d12570827-Reviews-Fushifaru_Maldives-Fushifaru.html">
        <img src="${pageContext.request.contextPath}/images/apps/trip-advisor.png" width="60" height="60"
             alt="trip advisor"/></a></p>
    <p><a href="https://www.instagram.com/fushifaru/?hl=en"> <img
            src="${pageContext.request.contextPath}/images/apps/instagram.png" width="50" height="50" alt="instagram"/></a>
    </p>

    <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <c:if test="${sessionScope.authorization}">
                <li class="nav-item">
                        ${sessionScope.userName} ${sessionScope.userSurname} ${sessionScope.userRole}
                </li>

                <c:if test="${sessionScope.userRole == 'CLIENT'}">
                    <li class="nav-item">
                            Balance: ${sessionScope.balance} $
                    </li>
                </c:if>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="#">Номера</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Об отеле</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Предложения</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Контакты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/jsp/navigation/authorization.jsp">Личный
                    кабинет</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>