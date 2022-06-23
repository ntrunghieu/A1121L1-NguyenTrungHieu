<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/06/2022
  Time: 2:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate" method="post">
    <h1>Exchange money</h1>
    <input type="text" name="vnd" placeholder="Input VND">
    <input type="text" name="exchangeRate" placeholder="Input exchange rate">
    <button type="submit">Exchange</button>
</form>

<div>
    <c:if test="${usd !=null}">
        <h1>USD is ${usd}</h1>
    </c:if>
</div>
</body>
</html>
