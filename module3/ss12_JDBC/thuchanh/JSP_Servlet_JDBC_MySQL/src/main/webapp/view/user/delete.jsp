<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/05/2022
  Time: 8:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users">List All Users</a>
        <h1>Confirm to delete this user?</h1>
    </h2>
</center>
<div align="center">
<form method="post" style="width: 30%;">
    <fieldset>
        <legend>User information</legend>
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
                <td><button type="submit">Delete</button> </td>
                <td><button type="button" onclick="window.location.href='/users'">Back to user list</button> </td>
            </tr>
        </table>
    </fieldset>
</form>
</div>
</body>
</html>
