<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/05/2022
  Time: 2:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--thu vien jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
    <style>
        div{
            width: 75%;
            height: 100%;
            text-align: center;
            margin: auto;

        }
        table{
            margin-top: 30px;

        }
        .link1{
            text-decoration: none;
        }
        .list{
            width: 90%;
            left: 50%;
            transform: translateX(5%);
        }
    </style>
</head>
<body>

<form action="/products" method="get">
    <h1>Product search</h1>
    <input type="text" name="name" placeholder="input name">
    <br>
    <input type="submit" name="action" value="search">
</form>


<h1>Danh sách sinh viên</h1>
<button type="button"><span><a href="/products?action=create" class="link1">Create a new product</a></span></button>
<form class="list">
<table border="1" style="border-collapse:  collapse" class="table">
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">Manufacturer</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    <c:forEach items="${productsList}" var="products" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td><a href="/products?action=view&id=${products.getId()}">${products.id}</a></td>
            <td><a href="/products?action=view&id=${products.getName()}">${products.name}</a></td>
            <td>${products.price}</td>
            <td>${products.description}</td>
            <td>${products.manufacturer}</td>
            <td><button type="button"><a href="/products?action=edit&id=${products.getId()}">Edit</a> </button></td>
            <td><button type="button"><span><a href="/products?action=delete&id=${products.getId()}">delete</a></span></button></td>
        </tr>
    </c:forEach>

</table>
</form>
<br> <br>
<br>

<div class="list1">
    <c:if test="${product!=null}">
        <%@include file="viewProduct.jsp"%>
    </c:if>
</div>
</body>
</html>

