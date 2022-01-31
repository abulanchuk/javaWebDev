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
    <title>Client's bank account</title>
    <%@include file="../../header/header.jsp" %>
</head>
<body>
<form class="mb-md-5 mt-md-4 pb-5" action="${pageContext.request.contextPath}/controller"
      method="post">
    <input type="hidden" name="command_name" value="update_cash">
    <div class="form-group row">
        <label for="bank_account" class="col-sm-2 col-form-label">Replenish account for:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control w-75" name="bank_account" id="bank_account"
                   placeholder="You can add less than 10 000$"
                   required pattern="^([1-9]|([1-9][0-9])|([1-9][0-9][0-9])||([1-9][0-9][0-9][0-9])|10000)$">
        </div>
        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">${Replenish}</button>
    </div>
</form>
<%@include file="../../footer/footer.jsp" %>
</body>
</html>
