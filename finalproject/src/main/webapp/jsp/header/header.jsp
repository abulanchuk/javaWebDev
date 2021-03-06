<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 10.01.2022
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="bundle/locale"/>


<fmt:message key="navigation.rooms" var="Rooms"/>
<fmt:message key="navigation.aboutHotel" var="AboutHotel"/>
<fmt:message key="navigation.contacts" var="Contacts"/>
<fmt:message key="navigation.sighIn" var="SighIn"/>
<fmt:message key="navigation.language" var="Language"/>
<fmt:message key="navigation.signOut" var="SignOut"/>
<fmt:message key="navigation.forOwner" var="ForOwner"/>
<fmt:message key="navigation.personalPage" var="PersonalPage"/>
<fmt:message key="navigation.forButler" var="ForButler"/>

<html>
<head>
    <title>Title</title>
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
    <p><a href="https://www.tripadvisor.com/Hotel_Review-g14991100-d12570827-Reviews-Fushifaru_Maldives-Fushifaru.html" target="_blank">
        <img src="${pageContext.request.contextPath}/images/apps/trip-advisor.png" width="60" height="60"
             alt="trip advisor"/></a></p>
    <p><a href="https://www.instagram.com/fushifaru/?hl=en" target="_blank"> <img
            src="${pageContext.request.contextPath}/images/apps/instagram.png" width="50" height="50" alt="instagram"/></a>
    </p>

    <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="main-navigation">
        <ul class="navbar-nav">
            <c:if test="${sessionScope.userRole =='OWNER' or sessionScope.userRole =='BUTLER'}">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/jsp/navigation/updatePersonalInformation.jsp"
                       class="text-white-50 fw-bold"> ${sessionScope.userName} ${sessionScope.userSurname}</a> ${sessionScope.userRole}
                </li>
            </c:if>

            <c:if test="${sessionScope.userRole == 'CLIENT'}">
                <li class="nav-item">
                        ${sessionScope.userName} ${sessionScope.userSurname}
                </li>
                <li class="nav-item">
                    Balance: ${sessionScope.balance} $
                </li>

                <li class="nav-item">
                    <a class="nav-link text-dark"
                       href="${pageContext.request.contextPath}/jsp/navigation/client/personalClientPage.jsp">${PersonalPage}</a>
                </li>
            </c:if>

            <c:if test="${sessionScope.userRole == 'OWNER'}">
                <li class="nav-item">
                    <a class="nav-link text-dark"
                       href="${pageContext.request.contextPath}/jsp/navigation/owner/workingpanel.jsp">${ForOwner}</a>
                </li>
            </c:if>

            <c:if test="${sessionScope.userRole == 'BUTLER'}">
                <li class="nav-item">
                    <a class="nav-link text-dark"
                       href="${pageContext.request.contextPath}/jsp/navigation/butler/butlerWorkingPanel.jsp">${ForButler}</a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link text-dark"
                   href="${pageContext.request.contextPath}/controller?command_name=show_all_rooms">${Rooms}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-dark"
                   href="${pageContext.request.contextPath}/jsp/navigation/contacts.jsp">${Contacts}</a>
            </li>

            <c:choose>
                <c:when test="${sessionScope.authorization}">
                    <li class=" nav-item">
                        <a class="nav-link text-dark "
                           href="${pageContext.request.contextPath}/controller?command_name=sign_out">${SignOut}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class=" nav-item">
                        <a class="nav-link text-dark "
                           href="${pageContext.request.contextPath}/jsp/navigation/authorization.jsp">${SighIn}</a>
                    </li>
                </c:otherwise>

            </c:choose>


        </ul>

        <div class="dropdown">
            <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton1"
                    data-bs-toggle="dropdown" aria-expanded="false">
                ${Language}
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item"
                       href="${pageContext.request.contextPath}/controller?command_name=change_locale&amp;locale=en">ENG</a>
                </li>
                <li><a class="dropdown-item"
                       href="${pageContext.request.contextPath}/controller?command_name=change_locale&amp;locale=ru">RU</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
</body>
</html>