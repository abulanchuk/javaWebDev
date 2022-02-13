<%-- Created by IntelliJ IDEA.
 User: Anna Bulanchuk
 Date: 26.01.2022
 Time: 17:44
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="current_page" value="${pageContext.request.requestURI}" scope="session"/>
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
<fmt:message key="workingPanelAdmin.delete" var="Delete"/>
<fmt:message key="workingPanelAdmin.activeOrders" var="ActiveOrders"/>
<fmt:message key="workingPanelAdmin.noActiveOrders" var="NoActiveOrders"/>

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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>
</head>
<body>
<%@include file="../../header/header.jsp" %>

<div class="accordion" id="accordionExample">
    <div class="accordion-item">
        <h2 class="accordion-header" id="headingOne">
            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseAddRoom"
                    aria-expanded="true" aria-controls="collapseAddRoom">
                ${AddRoom}
            </button>
        </h2>
        <div id="collapseAddRoom" class="accordion-collapse collapse show" aria-labelledby="headingOne"
             data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <nav class="navbar-light bg-light m-4">
                    <form class="form-row" action="${pageContext.request.contextPath}/controller" method="post">
                        <input type="hidden" name="command_name" value="add_room">

                        <div style="display: flex; flex-direction: row; width: 100%">
                            <input class="form-control mr-sm-2" name="price" type="search" placeholder="${Price}"
                                   aria-label="Search">
                            <input class="form-control mr-sm-2" name="room_type" type="search" placeholder="${RoomType}"
                                   aria-label="Search">
                            <input class="form-control mr-sm-2" name="floor" type="search" placeholder="Floor"
                                   aria-label="Search">
                            <input class="form-control mr-sm-2" name="room_number" type="search"
                                   placeholder="${RoomNumber}"
                                   aria-label="Search">
                            <input class="form-control mr-sm-2" name="id_discount" type="search"
                                   placeholder="${IdDiscount}"
                                   aria-label="Search">
                            <input class="form-control mr-sm-2" name="image_url" type="search" placeholder="${ImageUrl}"
                                   aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="Image path">${Add}</button>
                        </div>
                    </form>
                </nav>

            </div>
        </div>
    </div>
    <div class="accordion-item">
        <h2 class="accordion-header" id="headingTwo">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseAddOwner" aria-expanded="false" aria-controls="collapseAddOwner">
                ${AddOwner}
            </button>
        </h2>
        <div id="collapseAddOwner" class="accordion-collapse collapse" aria-labelledby="headingTwo"
             data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <div class="container h-100">
                    <div class="row justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-8 col-lg-6 col-xl-5 invisible-scroll"
                             style="overflow-y: auto; max-height:  100%">
                            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                                <div class="card-body p-3 text-center ">

                                    <div class="mb-md-3 mt-md-3 pb-3">
                                        <form class="mb-md-5 mt-md-4 pb-5"
                                              action="${pageContext.request.contextPath}/controller"
                                              method="post">
                                            <input type="hidden" name="command_name" value="add_owner">

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="login" id="typeLoginOwner"
                                                       placeholder="${LoginHolder}"
                                                       required pattern="[A-Za-z]{8,30}"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typeLoginOwner">${Login}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="password" name="password" id="typePasswordOwner"
                                                       placeholder="${PasswordHolder}" required
                                                       pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typePasswordOwner">${Password}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="name" id="typeNameOwner"
                                                       placeholder="${NameHolder}" required
                                                       pattern="^[A-ZА-Я][a-zа-я]{1,30}$"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typeNameOwner">${Name}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="surname" id="typeSurnameOwner"
                                                       placeholder="${SurnameHolder}"
                                                       required pattern="^[A-ZА-Я][a-zа-я]{2,50}$"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typeSurnameOwner">${Surname}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="phone_number" id="typePhoneNumberOwner"
                                                       placeholder="${PhoneHolder}" required
                                                       pattern="(25|29|33|44)\d{7}"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label"
                                                       for="typePhoneNumberOwner">${PhoneNumber}</label>
                                            </div>
                                            <button class="btn btn-outline-light btn-lg px-5"
                                                    type="submit">${Add}</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="accordion-item">
        <h2 class="accordion-header" id="headingThree">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseAddButler" aria-expanded="false" aria-controls="collapseAddButler">
                ${AddButler}
            </button>
        </h2>
        <div id="collapseAddButler" class="accordion-collapse collapse" aria-labelledby="headingThree"
             data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <div class="container h-100">
                    <div class="row justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-8 col-lg-6 col-xl-5 invisible-scroll"
                             style="overflow-y: auto; max-height:  100%">
                            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                                <div class="card-body p-3 text-center ">

                                    <div class="mb-md-3 mt-md-3 pb-3">
                                        <form class="mb-md-5 mt-md-4 pb-5"
                                              action="${pageContext.request.contextPath}/controller"
                                              method="post">
                                            <input type="hidden" name="command_name" value="add_butler">

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="login" id="typeLoginButler"
                                                       placeholder="${LoginHolder}"
                                                       required pattern="[A-Za-z]{8,30}"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typeLoginButler">${Login}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="password" name="password" id="typePasswordButler"
                                                       placeholder="${PasswordHolder}" required
                                                       pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typePasswordButler">${Password}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="name" id="typeNameButler"
                                                       placeholder="${NameHolder}" required
                                                       pattern="^[A-ZА-Я][a-zа-я]{1,30}$"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typeNameButler">${Name}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="surname" id="typeSurnameButler"
                                                       placeholder="${SurnameHolder}"
                                                       required pattern="^[A-ZА-Я][a-zа-я]{2,50}$"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label" for="typeSurnameButler">${Surname}</label>
                                            </div>

                                            <div class="form-outline form-white mb-2">
                                                <input type="text" name="phone_number" id="typePhoneNumberButler"
                                                       placeholder="${PhoneHolder}" required
                                                       pattern="(25|29|33|44)\d{7}"
                                                       class="form-control form-control-lg"/>
                                                <label class="form-label"
                                                       for="typePhoneNumberButler">${PhoneNumber}</label>
                                            </div>
                                            <button class="btn btn-outline-light btn-lg px-5"
                                                    type="submit">${Add}</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="accordion-item">
        <h2 class="accordion-header" id="headingFour">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseDeleteButler" aria-expanded="false" aria-controls="collapseDeleteButler">
                ${DeleteButler}
            </button>
        </h2>
        <div id="collapseDeleteButler" class="accordion-collapse collapse" aria-labelledby="headingFour"
             data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller"
                      method="post">
                    <input type="hidden" name="command_name" value="delete_butler">
                    <div class="form-group row">
                        <label for="loginButler" class="col-sm-2 col-form-label">Butler's login for deleting</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control w-75" name="login" id="loginButler"
                                   placeholder="Delete butler by this login"
                                   required pattern="[A-Za-z]{8,30}">
                        </div>
                        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">${Delete}</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="accordion-item">
        <h2 class="accordion-header" id="headingFive">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseDeleteClient" aria-expanded="false" aria-controls="collapseDeleteClient">
                ${DeleteClient}
            </button>
        </h2>
        <div id="collapseDeleteClient" class="accordion-collapse collapse" aria-labelledby="headingFive"
             data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller"
                      method="post">
                    <input type="hidden" name="command_name" value="delete_client">
                    <div class="form-group row">
                        <label for="login" class="col-sm-2 col-form-label">Client's login for deleting</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control w-75" name="login" id="login"
                                   placeholder="Delete client by this login"
                                   required pattern="[A-Za-z]{8,30}">
                        </div>
                        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">${Delete}</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>

<p>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample" onclick="document.location='${pageContext.request.contextPath}/controller?command_name=show_all_butlers'">
        ${ListButlers}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample"
            onclick="document.location='${pageContext.request.contextPath}/controller?command_name=show_all_clients'">
        ${ListClients}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample"
            onclick="document.location='${pageContext.request.contextPath}/controller?command_name=show_active_or_not_orders&is_active_order=true'">
        ${ActiveOrders}
    </button>
    <button class="btn btn-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample"
            aria-expanded="false" aria-controls="collapseExample"
            onclick="document.location='${pageContext.request.contextPath}/controller?command_name=show_active_or_not_orders&is_active_order=false'">
        ${NoActiveOrders}
    </button>
</p>


<%@include file="../../footer/footer.jsp" %>
</body>
</html>
