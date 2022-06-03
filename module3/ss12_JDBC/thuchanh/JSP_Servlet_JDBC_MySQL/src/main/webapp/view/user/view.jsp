<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03/06/2022
  Time: 4:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User information</h1>
<table>
    <tr>
        <td>Name: </td>
        <td>${user.getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${user.getEmail()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${user.getCountry()}</td>
    </tr>
    <tr>
        <td></td>
        <td><button type="button" onclick="window.location.href='/users'">Back to user list</button> </td>
    </tr>
</table>
</body>
</html>
