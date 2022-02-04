<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 31.01.2022
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="bundle/locale"/>

<fmt:message key="bankAccount.replenish" var="Replenish"/>
<fmt:message key="registration.submit" var="Submit"/>
<fmt:message key="bankAccount.replenishFor" var="ReplenishFor"/>
<fmt:message key="personalClientPage.replace" var="Replace"/>
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

    <title>Client's personal page</title>
    <%@include file="../../header/header.jsp" %>
</head>
<body>
<h1>Личный кабинет</h1>
<h2>${sessionScope.userName} ${sessionScope.userSurname}</h2>
<h3>Пополнить счет</h3>
<form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller"
      method="post">
    <input type="hidden" name="command_name" value="update_cash">
    <div class="form-group row">
        <label for="bank_account" class="col-sm-2 col-form-label">${ReplenishFor}</label>
        <div class="col-sm-10">
            <input type="text" class="form-control w-75" name="bank_account" id="bank_account"
                   placeholder="You can add less than 10 000$ (100, 500, 1000)"
                   required pattern="^([1-9]|([1-9][0-9])|([1-9][0-9][0-9])||([1-9][0-9][0-9][0-9])|10000)$">
        </div>
        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">${Replenish}</button>
    </div>
</form>

<h3>Изменить пароль</h3>
<form class="mb-md-5 mt-md-4 pb-5 mx-5" action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command_name" value="change_password">
    <div class="form-group row">
        <label for="old_password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control w-75" name="old_password" id="old_password" placeholder="Old password"
                   required pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
        </div>
    </div>
    <div class="form-group row">
        <label for="new_password" class="col-sm-2 col-form-label">Новый пароль</label>
        <div class="col-sm-10">
            <input type="password" class="form-control w-75" name="new_password" id="new_password" placeholder="New password" required
                   pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
        </div>
    </div>
    <button class="btn btn-secondary btn-lg " type="submit">${Replace}</button>
</form>

<h3>Изменить персональные данные</h3>
<form class="mb-md-5 mt-md-4 pb-5 mx-5" action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command_name" value="edit_personal_information_about_client">
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
    <button class="btn btn-secondary btn-lg " type="submit">${Submit}</button>
</form>

<%@include file="../../footer/footer.jsp" %>
</body>
</html>
