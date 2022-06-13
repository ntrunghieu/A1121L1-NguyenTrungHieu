<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 09/06/2022
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            margin-top: 30px;

        }

        .btn-create {
            margin: 7px;
        }

        /*h3 {*/
        /*    text-align: center;*/
        /*    margin: 10px;*/
        /*}*/

        .table-area {
            width: 50%;
            margin-top: 60px;
            left: 50%;
            transform: translateX(7%);
        }
    </style>
</head>
<body>
<%@include file="../header.jsp"%>
table id="tableStudent" class="table table-area" style="width: 80%">
<thead>
<tr>
    <th scope="col">STT</th>
    <th scope="col">Id</th>
    <th>Type</th>
    <th>Username</th>
    <th>Birthday</th>
    <th>Gender</th>
    <th>ID Card</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Address</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach items="${listCustomer}" var="cus" varStatus="status">
    <tr>
        <th scope="row">${status.count}</th>
        <td>${cus.id}</td>
        <c:if test="${cus.typeId==1}">
            <td>Diamond</td>
        </c:if>
        <c:if test="${cus.typeId==2}">
            <td>Platinium</td>
        </c:if>
        <c:if test="${cus.typeId==3}">
            <td>Gold</td>
        </c:if>
        <c:if test="${cus.typeId==4}">
            <td>Silver</td>
        </c:if>
        <c:if test="${cus.typeId==5}">
            <td>Member</td>
        </c:if>
        <td>${cus.name}</td>
        <td>${cus.birthday}</td>
        <c:if test="${cus.gender==0}">
            <td>Male</td>
        </c:if>
        <c:if test="${cus.gender==1}">
            <td>Female</td>
        </c:if>
        <td>${cus.idCard}</td>
        <td>${cus.phone}</td>
        <td>${cus.email}</td>
        <td>${cus.address}</td>
        <td>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editForm"
                    onclick="showEdit('${cus.id}',${cus.typeId},'${cus.name}','${cus.birthday}','${cus.gender}',
                            '${cus.idCard}','${cus.phone}','${cus.email}','${cus.address}')">Edit
            </button>
        </td>
        <td>
            <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#deleteForm"
                    onclick="showDelete('${cus.id}','${cus.name}')">Delete</a>
            </button>
        </td>
    </tr>

</c:forEach>
</tbody>
</table>
</body>
</html>
