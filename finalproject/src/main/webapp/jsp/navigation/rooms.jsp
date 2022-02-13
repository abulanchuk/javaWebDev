<%@ page import="java.util.List" %>
<%@ page import="com.example.finalproject.model.entity.Room" %><%--
  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 22.01.2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="bundle/locale"/>

<fmt:message key="rooms.makeReservation" var="Reservation"/>
<fmt:message key="rooms.price" var="Price"/>

<html>
<head>
    <title>Rooms</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/rooms.css" type="text/css">

    <script type="text/javascript">
        let MAX_ROOMS_AT_PAGE = 3;
        let current_page_index = 0;
        let rooms_array = [];

        function update_page() {
            $("#all_rooms_block").empty();

            for (idx = current_page_index * MAX_ROOMS_AT_PAGE; idx < (current_page_index + 1) * MAX_ROOMS_AT_PAGE; ++idx) {
                $("#all_rooms_block").append(rooms_array[idx]);
            }

            $("#current_page_button").text(current_page_index + 1);
            $("html, body").animate({ scrollTop: 0 }, "fast");
        }

        function prev_button_clicked() {
            if (current_page_index === 0) {
                return;
            }

            current_page_index--;
            update_page();
        }

        function next_button_click() {
            if (current_page_index + 1 >= Math.ceil(rooms_array.length / MAX_ROOMS_AT_PAGE)) {
                return;
            }

            current_page_index++;
            update_page();
        }

        function collect_rooms() {
            $("#all_rooms_block").children().each((i, item) => {
                let html_code = $(item).html();
                rooms_array.push(html_code)
            });
        }

        $(document).ready(function () {
            collect_rooms();
            update_page();

            $("#prev_page_button").click(prev_button_clicked);
            $("#next_page_button").click(next_button_click);
        });

    </script>

</head>
<body>
<%@include file="../header/header.jsp" %>

<%
    List<Room> roomsAvailable = (List<Room>) (request.getAttribute("catalog"));
%>

<div id="all_rooms_block">
    <% for (int i = 0; i < roomsAvailable.size(); ++i) { %>
    <div class="card mb-3">
        <div class="row g-0">
            <div class="col-md-8">
                <img src="${pageContext.request.contextPath}<%=roomsAvailable.get(i).getImageUrl()%>"
                     class="img-fluid rounded-start w-100" alt="номера на мальдивах">
            </div>
            <div class="col-md-4">
                <div class="card-body">
                    <h5 class="card-title"><%=roomsAvailable.get(i).getRoomType()%>
                    </h5>
                    <p class="card-text">${Price}: <%=roomsAvailable.get(i).getPrice() + " $"%>
                    </p>

                    <c:choose>
                        <c:when test="${sessionScope.userRole == 'CLIENT'}">

                            <form action="${pageContext.request.contextPath}/controller" method="post">
                                <input type="hidden" name="command_name" value="select_booking_dates">
                                <input type="hidden" name="room_id" value="<%=roomsAvailable.get(i).getIdRoom()%>">
                                <input type="submit" class="btn btn-secondary btn-lg px-5" value="${Reservation}"/>
                            </form>

                        </c:when>
                        <c:otherwise>
                            <li class=" nav-item">
                                <button class="btn btn-secondary btn-lg px-5"
                                        onclick="document.location='${pageContext.request.contextPath}/jsp/navigation/authorization.jsp'">
                                        ${Reservation}
                                </button>
                            </li>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>
    <%} %>
</div>

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" id="prev_page_button" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li class="page-item"><a class="page-link" id="current_page_button">1</a></li>
        <li class="page-item">
            <a class="page-link" id="next_page_button" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

<%@include file="../footer/footer.jsp" %>
</body>
</html>
