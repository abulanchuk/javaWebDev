  Created by IntelliJ IDEA.
  User: Anna Bulanchuk
  Date: 12.01.2022
  Time: 20:40
  To change this template use File | Settings | File Templates.
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
Request from ${pageContext.errorData.requestURI} is failed
Servlet name: ${pageContext.errorData.servletName}
Status code: ${pageContext.errorData.statusCode}
Exception: ${pageContext.exception}
Message from exception: ${pageContext.exception.message}
<a href="/main.jsp">Back to main</a>
</body>
</html>
