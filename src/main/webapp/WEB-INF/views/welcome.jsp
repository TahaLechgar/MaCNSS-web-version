<%--
  Created by IntelliJ IDEA.
  User: Taha Lechgar
  Date: 12/7/2022
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${admins}" var="admin" >
        <c:out value="${admin.email}"/>
    </c:forEach>
    <br>
</body>
</html>
