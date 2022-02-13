<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 13.01.2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="current_page" value="${pageContext.request.requestURI}" scope="session"/>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="bundle/locale"/>

<fmt:message key="registration.registration" var="Registration"/>
<fmt:message key="registration.message" var="Message"/>
<fmt:message key="registration.login" var="Login"/>
<fmt:message key="registration.password" var="Password"/>
<fmt:message key="registration.name" var="Name"/>
<fmt:message key="registration.surname" var="Surname"/>
<fmt:message key="registration.passportNumber" var="PassportNumber"/>
<fmt:message key="registration.phoneNumber" var="PhoneNumber"/>
<fmt:message key="registration.email" var="Email"/>
<fmt:message key="registration.submit" var="Submit"/>
<fmt:message key="registration.loginPlaceHolder" var="LoginHolder"/>
<fmt:message key="registration.passwordPlaceHolder" var="PasswordHolder"/>
<fmt:message key="registration.namePlaceHolder" var="NameHolder"/>
<fmt:message key="registration.surnamePlaceHolder" var="SurnameHolder"/>
<fmt:message key="registration.passportNumberPlaceHolder" var="PassportHolder"/>
<fmt:message key="registration.phoneNumberPlaceHolder" var="PhoneHolder"/>
<fmt:message key="registration.emailPlaceHolder" var="EmailHolder"/>

<html>
<head>
    <title>Registration</title>
    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/authorization.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registration.css" type="text/css">
    <script type="text/javascript">
        function disableBack() {
            window.history.forward();
        }

        setTimeout("disableBack()", 0);
        window.onunload = function () {
            null
        };
    </script>
    <title>Registration</title>
</head>
<body>
<%@include file="../header/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<section class="vh-100 gradient-custom">
    <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5 invisible-scroll" style="overflow-y: auto; max-height:  100%">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-3 text-center ">

                        <div class="mb-md-3 mt-md-3 pb-3">
                            <form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller" method="post">
                                <input type="hidden" name="command_name" value="sign_up">

                            <h2 class="fw-bold mb-2 text-uppercase">${Registration}</h2>
                            <p class="text-white-50 mb-5">${Message}</p>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name="login" id="typeLogin" placeholder="${LoginHolder}" required pattern="[A-Za-z]{8,30}" class="form-control form-control-lg" />
                                <label class="form-label" for="typeLogin">${Login}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" name ="password" id="typePasswordX" placeholder="${PasswordHolder}" required pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typePasswordX">${Password}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name ="name" id="typeName" placeholder="${NameHolder}" required pattern="^[A-ZА-Я][a-zа-я]{1,30}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typeName">${Name}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name = "surname"  id="typeSurname" placeholder="${SurnameHolder}" required pattern="^[A-ZА-Я][a-zа-я]{2,50}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typeSurname">${Surname}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name = "phone_number"  id="typePhoneNumber" placeholder="${PhoneHolder}" required pattern="(25|29|33|44)\d{7}" class="form-control form-control-lg" />
                                <label class="form-label" for="typePhoneNumber">${PhoneNumber}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text"  name = "passport_number" id="typePassportNumber" placeholder="${PassportHolder}" required pattern="[A-Z]{2}[0-9]{7}" class="form-control form-control-lg" />
                                <label class="form-label" for="typePassportNumber">${PassportNumber}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="email" name = "email" id="email" placeholder="${EmailHolder}" required pattern="^[A-Za-z0-9-.]{1,30}@[a-z]{2,7}\.[a-z]{2,4}$" class="form-control form-control-lg" />
                                <label class="form-label" for="email">${Email}</label>
                            </div>

                            <button class="btn btn-outline-light btn-lg px-5" type="submit">${Submit}</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../footer/footer.jsp" %>
</body>
</html>
