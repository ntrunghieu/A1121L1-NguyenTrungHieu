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
    <link rel="stylesheet" href="/bootstrap4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />


</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <button><span><a href="/users?action=create">Add New User</a></span></button>
        <button onclick="window.location.href='/users'">View full list</button>
        <form action="/users?action=search" method="get">
            <input hidden name="action" value="search">
            <input type="text"  name="nameCountry">
            <span><button type="submit" >Search</button> </span>
        </form>
    </h2>
    <div>
        <span>Sắp xếp theo</span>
        <form action="/users?action=sortList" method="get">
            <input hidden name="action" value="sortList">
            <input hidden name="nameCountry" value="<%= request.getParameter("sortAttribute")%>">
            <select name="sortAttribute">
                <option value="name" selected>name</option>
                <option value="email">email</option>
                <option value="country">country</option>
            </select>
            <button type="submit">Sort</button>
        </form>
    </div>
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

<%--        <c:if test="${param.action=='search'}">--%>
<%--            <c:forEach items="${users}" var="users" varStatus="status">--%>
<%--                <tr>--%>
<%--                    <td>${status.index}</td>--%>
<%--                    <td><a href="/users?action=view&id=${users.getId()}">${users.id}</a></td>--%>
<%--                    <td><a href="/users?action=view&id=${users.getName()}">${users.name}</a></td>--%>
<%--                    <td>${users.email}</td>--%>
<%--                    <td>${users.country}</td>--%>
<%--                    <td>--%>
<%--                        <button type="button"><a href="/users?action=edit&id=${users.getId()}">Edit</a></button>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <button type="button"><span><a href="/users?action=delete&id=${users.getId()}">delete</a></span>--%>
<%--                        </button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </c:if>--%>


    </table>
</div>


<script src="jquery/jquery-3.6.0.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>
