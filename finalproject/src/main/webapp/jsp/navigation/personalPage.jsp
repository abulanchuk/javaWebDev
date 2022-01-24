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
<h1>Личный кабинет</h1>
<h2>${sessionScope.userName} ${sessionScope.userSurname}</h2>


<form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command_name" value="edit_personal_information">
    <div class="form-group row">
        <label for="login" class="col-sm-2 col-form-label">Login</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="login" id="login" placeholder="New login" required pattern="[A-Za-z]{8,30}">
        </div>
    </div>
    </div>
    <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="password" id="password" placeholder="New password" required pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
        </div>
    </div>
    <div class="form-group row">
        <label for="name" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="name" id="name" placeholder="New name" required pattern="^[A-ZА-Я][a-zа-я]{1,30}$">
        </div>
    </div>
    <div class="form-group row">
        <label for="surname" class="col-sm-2 col-form-label">Surname</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="surname" id="surname" placeholder="New surname" required pattern="^[A-ZА-Я][a-zа-я]{2,50}$">
        </div>
    </div>
    <div class="form-group row">
        <label for="phoneNumber" class="col-sm-2 col-form-label">Phone number</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name ="phone_number" id="phoneNumber" placeholder="New phone number" required pattern="(25|29|33|44)\d{7}">
        </div>
    </div>
    <button class="btn btn-outline-light btn-lg px-5" type="submit">Submit</button>
</form>

<%@include file="../footer/footer.jsp" %>
</body>
</html>
