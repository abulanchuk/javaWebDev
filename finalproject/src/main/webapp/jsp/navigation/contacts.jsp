<%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 26.01.2022
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Contacts</title>
    <script type="text/javascript">
        function disableBack() {
            window.history.forward();
        }

        setTimeout("disableBack()", 0);
        window.onunload = function () {
            null
        };
    </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>
</head>
<body>
<%@include file="../header/header.jsp" %>
<div class="container">
    <div class="row-fluid">
        <div class="span8">
            <iframe width="100%" height="350" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1384.0097091214102!2d73.51410443947039!3d5.4911079892091355!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3b152a7e80429cc7%3A0x13eaf5356dd4ed88!2z0KTRg9GI0LjRhNCw0YDRgw!5e0!3m2!1sru!2sby!4v1643195037697!5m2!1sru!2sby" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
        </div>

        <div class="span4">
            <h2>Fishfaru Maldives</h2>
            <address>
                <strong>Отель для особенного и незабываемого отдыха</strong><br>
                Лавияни, Мальдивы<br>
                <strong>Позвоните и мы расскажем все о нас!</strong><br>
                CT21 5SH<br>
                <abbr title="Phone">P:</abbr> +960-662-0202
            </address>
        </div>
    </div>
</div>
<%@include file="../footer/footer.jsp" %>
</body>
</html>
