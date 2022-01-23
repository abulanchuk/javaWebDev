<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 11.01.2022
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="current_page" value="${pageContext.request.requestURI}" scope="session"/>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="bundle/locale"/>

<fmt:message key="authorization.message" var="Message"/>
<fmt:message key="authorization.signIn" var="SignIn"/>
<fmt:message key="authorization.login" var="Login"/>
<fmt:message key="authorization.password" var="Password"/>
<fmt:message key="authorization.dontHaveAccount" var="HaveAccount"/>
<fmt:message key="authorization.registration" var="Registration"/>

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
    <title>Authorization</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/authorization.css" type="text/css">
</head>
<body>
<%@include file="../header/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<section class="vh-100 gradient-custom">
    <div class="container h-75">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command_name" value="sign_in">

                            <h2 class="fw-bold mb-2 text-uppercase">${SighIn}</h2>
                            <p class="text-white-50 mb-5">${Message}</p>

                            <div class="form-outline form-white mb-4">
                                <input type="text" name="login" id="typeEmailX" class="form-control form-control-lg" />
                                <label class="form-label" for="typeEmailX">${Login}</label>
                            </div>

                            <div class="form-outline form-white mb-4">
                                <input type="password" name="password" id="typePasswordX" class="form-control form-control-lg" />
                                <label class="form-label" for="typePasswordX">${Password}</label>
                            </div>

                            <button class="btn btn-outline-light btn-lg px-5" type="submit">${SighIn}</button>



                        </form>

                        <div>
                            <p class="mb-0">${HaveAccount} <a href="${pageContext.request.contextPath}/jsp/navigation/registration.jsp" class="text-white-50 fw-bold">${Registration}</a></p>
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
