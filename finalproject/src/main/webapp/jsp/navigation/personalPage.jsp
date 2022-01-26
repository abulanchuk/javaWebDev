<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 24.01.2022
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/rooms.css" type="text/css">
    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script type="text/javascript">
        function disableBack() {
            window.history.forward();
        }

        setTimeout("disableBack()", 0);
        window.onunload = function () {
            null
        };
    </script>
    <title>Personal page</title>

</head>
<body>
<%@include file="../header/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<div style="display: flex; flex-direction: column; align-items: center">

    <h1>Личный кабинет</h1>
    <h2>${sessionScope.userName} ${sessionScope.userSurname}</h2>
    <h3>Изменить персональные данные</h3>
</div>

<form class="mb-md-5 mt-md-4 pb-5 mx-5" action="${pageContext.request.contextPath}/controller" method="post">


    <c:choose>
        <c:when test="${sessionScope.userRole == 'CLIENT'}">
            <input type="hidden" name="command_name" value="edit_personal_information_about_client">
        </c:when>
        <c:otherwise>
            <input type="hidden" name="command_name" value="edit_personal_information">
        </c:otherwise>

    </c:choose>

    <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control w-75" name="password" id="password" placeholder="New password"
                   required pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
        </div>
    </div>
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control w-75" name="name" id="name" placeholder="New name" required
                   pattern="^[A-ZА-Я][a-zа-я]{1,30}$">
        </div>
    </div>
    <div class="form-group row">
        <label for="surname" class="col-sm-2 col-form-label">Surname</label>
        <div class="col-sm-10">
            <input type="text" class="form-control w-75" name="surname" id="surname" placeholder="New surname" required
                   pattern="^[A-ZА-Я][a-zа-я]{2,50}$">
        </div>
    </div>
    <div class="form-group row">
        <label for="phoneNumber" class="col-sm-2 col-form-label">Phone number</label>
        <div class="col-sm-10">
            <input type="text" class="form-control w-75" name="phone_number" id="phoneNumber"
                   placeholder="New phone number"
                   required pattern="(25|29|33|44)\d{7}">
        </div>
    </div>

    <c:if test="${sessionScope.userRole == 'CLIENT'}">
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control w-75" name="email" id="email" placeholder="New email"
                       required pattern="^[A-Za-z0-9-.]{1,30}@[a-z]{2,7}\.[a-z]{2,4}$">
            </div>
        </div>
        <div class="form-group row">
            <label for="passport_number" class="col-sm-2 col-form-label">Passport number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control w-75" name="passport_number" id="passport_number"
                       placeholder="New passport number"
                       required pattern="[A-Z]{2}[0-9]{7}">
            </div>
        </div>
    </c:if>

    <button class="btn btn-secondary btn-lg " type="submit">Submit</button>
</form>

<%@include file="../footer/footer.jsp" %>
</body>
</html>
