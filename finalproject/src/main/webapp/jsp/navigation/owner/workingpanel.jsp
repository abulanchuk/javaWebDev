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

<fmt:message key="registration.login" var="Login"/>
<fmt:message key="registration.password" var="Password"/>
<fmt:message key="registration.name" var="Name"/>
<fmt:message key="registration.surname" var="Surname"/>
<fmt:message key="registration.passportNumber" var="PassportNumber"/>
<fmt:message key="registration.phoneNumber" var="PhoneNumber"/>
<fmt:message key="registration.submit" var="Submit"/>
<fmt:message key="registration.loginPlaceHolder" var="LoginHolder"/>
<fmt:message key="registration.passwordPlaceHolder" var="PasswordHolder"/>
<fmt:message key="registration.namePlaceHolder" var="NameHolder"/>
<fmt:message key="registration.surnamePlaceHolder" var="SurnameHolder"/>
<fmt:message key="registration.passportNumberPlaceHolder" var="PassportHolder"/>
<fmt:message key="registration.phoneNumberPlaceHolder" var="PhoneHolder"/>

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



<div class="container h-100">
    <div class="row justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5 invisible-scroll" style="overflow-y: auto; max-height:  100%">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                <div class="card-body p-3 text-center ">

                    <div class="mb-md-3 mt-md-3 pb-3">
                        <form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command_name" value="add_butler">

                            <div class="form-outline form-white mb-2">
                                <input type="text" name="login" id="typeLoginButler" placeholder="${LoginHolder}" required pattern="[A-Za-z]{8,30}" class="form-control form-control-lg" />
                                <label class="form-label" for="typeLoginButler">${Login}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" name ="password" id="typePasswordButler" placeholder="${PasswordHolder}" required pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typePasswordButler">${Password}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name ="name" id="typeNameButler" placeholder="${NameHolder}" required pattern="^[A-ZА-Я][a-zа-я]{1,30}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typeName">${Name}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name = "surname"  id="typeSurnameButler" placeholder="${SurnameHolder}" required pattern="^[A-ZА-Я][a-zа-я]{2,50}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typeSurname">${Surname}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name = "phone_number"  id="typePhoneNumberButler" placeholder="${PhoneHolder}" required pattern="(25|29|33|44)\d{7}" class="form-control form-control-lg" />
                                <label class="form-label" for="typePhoneNumberButler">${PhoneNumber}</label>
                            </div>


                            <button class="btn btn-outline-light btn-lg px-5" type="submit">${Submit}</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container h-100">
    <div class="row justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5 invisible-scroll" style="overflow-y: auto; max-height:  100%">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                <div class="card-body p-3 text-center ">

                    <div class="mb-md-3 mt-md-3 pb-3">
                        <form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command_name" value="add_owner">

                            <div class="form-outline form-white mb-2">
                                <input type="text" name="login" id="typeLoginOwner" placeholder="${LoginHolder}" required pattern="[A-Za-z]{8,30}" class="form-control form-control-lg" />
                                <label class="form-label" for="typeLoginOwner">${Login}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" name ="password" id="typePasswordOwner" placeholder="${PasswordHolder}" required pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typePasswordOwner">${Password}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name ="name" id="typeNameOwner" placeholder="${NameHolder}" required pattern="^[A-ZА-Я][a-zа-я]{1,30}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typeNameOwner">${Name}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name = "surname"  id="typeSurnameOwner" placeholder="${SurnameHolder}" required pattern="^[A-ZА-Я][a-zа-я]{2,50}$" class="form-control form-control-lg" />
                                <label class="form-label" for="typeSurnameOwner">${Surname}</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="text" name = "phone_number"  id="typePhoneNumberOwner" placeholder="${PhoneHolder}" required pattern="(25|29|33|44)\d{7}" class="form-control form-control-lg" />
                                <label class="form-label" for="typePhoneNumberOwner">${PhoneNumber}</label>
                            </div>


                            <button class="btn btn-outline-light btn-lg px-5" type="submit">${Submit}</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../../footer/footer.jsp" %>
</body>
</html>
