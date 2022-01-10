<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 10.01.2022
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <script>
        function preventBack() {
            window.history.forward();
        }
        setTimeout("preventBack()", 0);
        window.onunload = function() {
            null
        };
    </script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <title>Fushifaru hotel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <!-- ChiefSlider JavaScript -->
    <script defer src="${pageContext.request.contextPath}/js/slider.js"></script>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            const slider = new ChiefSlider('.slider', {
                loop: false
            });
        });
    </script>
</head>
<body>
<%@include file="../header/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<div class="container">

    <div class="slider">
        <div class="slider__container">
            <div class="slider__wrapper">
                <div class="slider__items">
                    <div class="slider__item">
                        <img src="${pageContext.request.contextPath}/images/slider/slider1.jpg" style='height: 80%; width: 100%; display: block' alt="logo hotel"/></a>
                    </div>
                    <div class="slider__item">
                        <img src="${pageContext.request.contextPath}/images/slider/slider2.jpg" style='height: 80%; width: 100%; display: block' alt="logo hotel"/></a>
                    </div>
                    <div class="slider__item">
                        <img src="${pageContext.request.contextPath}/images/slider/slider3.jpg" style='height: 80%; width: 100%; display: block' alt="logo hotel"/></a>
                    </div>
                </div>
            </div>
        </div>
        <a href="#" class="slider__control" data-slide="prev"></a>
        <a href="#" class="slider__control" data-slide="next"></a>
    </div>

</div>


<%@include file="../footer/footer.jsp" %>

</body>
</html>
