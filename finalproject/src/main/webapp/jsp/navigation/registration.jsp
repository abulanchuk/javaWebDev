<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 13.01.2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/authorization.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registration.css" type="text/css">
</head>
<body>
<%@include file="../header/header.jsp" %>

<section class="vh-100 gradient-custom">
    <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5 invisible-scroll" style="overflow-y: auto; max-height:  100%">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-3 text-center ">

                        <div class="mb-md-3 mt-md-3 pb-3">

                            <h2 class="fw-bold mb-2 text-uppercase">Sign Up</h2>
                            <p class="text-white-50 mb-5">Please enter information about you!</p>

                            <div class="form-outline form-white mb-2">
                                <input type="email" id="typeLogin" class="form-control form-control-lg" />
                                <label class="form-label" for="typeLogin">Login</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" id="typePasswordX" class="form-control form-control-lg" />
                                <label class="form-label" for="typePasswordX">Password</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" id="typeName" class="form-control form-control-lg" />
                                <label class="form-label" for="typeName">Name</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" id="typeSurname" class="form-control form-control-lg" />
                                <label class="form-label" for="typeSurname">Surname</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" id="typePhoneNumber" class="form-control form-control-lg" />
                                <label class="form-label" for="typePhoneNumber">Phone number</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="password" id="typePassportNumber" class="form-control form-control-lg" />
                                <label class="form-label" for="typePassportNumber">Passport number</label>
                            </div>

                            <div class="form-outline form-white mb-2">
                                <input type="email" id="typeEmailX" class="form-control form-control-lg" />
                                <label class="form-label" for="typeEmailX">Email</label>
                            </div>



                            <button class="btn btn-outline-light btn-lg px-5" type="submit">Submit</button>

                            <div class="d-flex justify-content-center text-center mt-4 pt-1">
                                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                            </div>

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
