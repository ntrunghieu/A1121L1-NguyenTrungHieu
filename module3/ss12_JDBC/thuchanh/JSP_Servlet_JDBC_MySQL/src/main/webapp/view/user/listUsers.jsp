<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/05/2022
  Time: 8:56 CH
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
        <button><span><a href="/users?action=create">Add New User</a></span></button>
        <button onclick="window.location.href='/controller'">View full list</button>
    </h2>
</center>
<%--<button type="button"><span><a href="/users?action=create" class="link1">Create a new user</a></span></button>--%>

<div align="center">
<table border="1" style="border-collapse:  collapse" class="table">
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Country</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    <c:forEach items="${listUser}" var="users" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td><a href="/users?action=view&id=${users.getId()}">${users.id}</a></td>
            <td><a href="/users?action=view&id=${users.getName()}">${users.name}</a></td>
            <td>${users.email}</td>
            <td>${users.country}</td>
            <td>
                <button type="button"><a href="/users?action=edit&id=${users.getId()}">Edit</a></button>
            </td>
            <td>
                <button type="button"><span><a href="/users?action=delete&id=${users.getId()}">delete</a></span>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
