<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 26.01.2022
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="bundle/locale"/>

<fmt:message key="workingPanelAdmin.addRoom" var="AddRoom"/>
<fmt:message key="workingPanelAdmin.addButler" var="AddButler"/>
<fmt:message key="workingPanelAdmin.addOwner" var="AddOwner"/>
<fmt:message key="workingPanelAdmin.deleteButler" var="DeleteButler"/>
<fmt:message key="workingPanelAdmin.deleteClient" var="DeleteClient"/>
<fmt:message key="workingPanelAdmin.listButlers" var="ListButlers"/>
<fmt:message key="workingPanelAdmin.listClients" var="ListClients"/>
<fmt:message key="workingPanelAdmin.price" var="Price"/>
<fmt:message key="workingPanelAdmin.roomType" var="RoomType"/>
<fmt:message key="workingPanelAdmin.Floor" var="Floor"/>
<fmt:message key="workingPanelAdmin.numberRoom" var="RoomNumber"/>
<fmt:message key="workingPanelAdmin.idDiscount" var="IdDiscount"/>
<fmt:message key="workingPanelAdmin.imageUrl" var="ImageUrl"/>
<fmt:message key="workingPanelAdmin.add" var="Add"/>

<html>
<head>
    <title>Owner's panel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>
</head>
<body>
<%@include file="../../header/header.jsp" %>

<p>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        ${AddRoom}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        ${AddOwner}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        ${AddButler}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        ${DeleteButler}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        ${DeleteClient}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        ${ListButlers}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample">
        ${ListClients}
    </button>
</p>
<div class="collapse" id="collapseExample">
    <div class="card card-body">
        Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user
        activates the relevant trigger.
    </div>
</div>

<nav class="navbar-light bg-light m-4">
    <form class="form-row" action="${pageContext.request.contextPath}/controller" method="post">
        <input type="hidden" name="command_name" value="add_room">
        <div style="display: flex; flex-direction: row; width: 100%">
            <input class="form-control mr-sm-2" name="price" type="search" placeholder="${Price}"
                   aria-label="Search">
            <input class="form-control mr-sm-2" name="room_type" type="search" placeholder="${RoomType}"
                   aria-label="Search">
            <input class="form-control mr-sm-2" name="floor" type="search" placeholder="Floor" aria-label="Search">
            <input class="form-control mr-sm-2" name="room_number" type="search" placeholder="${RoomNumber}"
                   aria-label="Search">
            <input class="form-control mr-sm-2" name = "id_discount" type="search" placeholder="${IdDiscount}" aria-label="Search">
            <input class="form-control mr-sm-2" name = "image_url" type="search" placeholder="${ImageUrl}" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="Image path">${Add}</button>
        </div>
    </form>
</nav>

<%@include file="../../footer/footer.jsp" %>
</body>
</html>
