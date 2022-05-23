<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/05/2022
  Time: 2:09 CH
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--    <script src="jquery/jquery-3.6.0.min.js"></script>--%>
    <%--    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">--%>
    <%--    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>--%>


    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
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
    </style>
</head>
<body>
<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Address</th>
            <th scope="col">Img</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customersList}" var="customer" varStatus="status">
            <tr>
                <td> ${status.count}</td>
                <td>${customer.name}</td>
                <td>${customer.birthDay}</td>
                <td>${customer.address}</td>
                <td> <img src="${customer.img}" style="width: 50px;height: 50px;"></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
