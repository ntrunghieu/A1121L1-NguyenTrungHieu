<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/05/2022
  Time: 3:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result: </h1>
<c:if test="${!message.equals('')}">${message}</c:if>
<c:if test="${message.equals('')}"><span>${first_number} ${operator} ${last_number} = ${result}</span></c:if>
</body>
</html>
