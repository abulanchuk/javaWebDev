<%@ page import="com.example.finalproject.model.entity.Room" %><%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 03.02.2022
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:message key="rooms.price" var="Price"/>
<html>
<head>
    <title>Оформление заказа</title>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/jpg" href="${pageContext.request.contextPath}/images/favicon.ico"/>

    <script type="text/javascript">
        function updateTotalSum() {
            var start_date = Date.parse($("#start_date").val());
            var leave_date = Date.parse($("#leave_date").val());
            if (Number.isNaN(start_date) || Number.isNaN(leave_date) || start_date >= leave_date) {
                $("#days_count").text("");
                $("#total").text("");
                // TODO
                $("#submitButton").prop('disabled', true);
                return;
            }

            var millisBetween = leave_date - start_date;
            var days = millisBetween / (1000 * 3600 * 24);
            days = Math.round(Math.abs(days));
            $("#days_count").text(days);
            var totalCost = days * parseInt($("#room_price").text());
            $("#total_ui").text(totalCost);
            $("#total").val(totalCost);
            $("#submitButton").prop('disabled', false);
        }

        $(document).ready(function () {
            $("#start_date").change(function () {
                updateTotalSum();
            })

            $("#leave_date").change(function () {
                updateTotalSum();
            })
        })

    </script>

</head>
<body>
<%@include file="../../header/header.jsp" %>

<%Room room = (Room) (request.getAttribute("room"));%>

<table class="table">
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col">Тип комнаты</th>
        <th scope="col">Дата заселения</th>
        <th scope="col">Дата выселения</th>
        <th scope="col">Цена за ночь, $</th>
        <th scope="col">Кол-во ночей</th>
        <th>Итого:</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command_name" value="create_order">
            <input type="hidden" id="total" name="total" value="0">

            <th scope="row"><img src="${pageContext.request.contextPath}<%=room.getImageUrl()%>"
                                 class="img-fluid rounded-start w-10" alt="номера на мальдивах"></th>
            <td><%=room.getRoomType()%>
            </td>
            <td>
                <input id="start_date" type="date" name="start_date" required
                       pattern="(0[1-9]|[12][0-9]|3[01])\.(0[1-9]|1[0-2])\.(\d{4})">
            </td>
            <td><input id="leave_date" type="date" name="leave_date" required
                       pattern="(0[1-9]|[12][0-9]|3[01])\.(0[1-9]|1[0-2])\.(\d{4})"></td>
            <td id="room_price"><%= room.getPrice() + " $"%>
            </td>
            <td id="days_count">
            </td>
            <td id="total_ui"></td>
            <td>
                <input class="btn btn-secondary btn-lg " type="submit" id="submitButton"
                       disabled="true" value="Оформить"/>
            </td>
        </form>
    </tr>
    </tbody>
</table>

<%@include file="../../footer/footer.jsp" %>
</body>
</html>
