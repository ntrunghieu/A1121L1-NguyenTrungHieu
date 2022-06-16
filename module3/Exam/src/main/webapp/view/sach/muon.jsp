<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/06/2022
  Time: 10:14 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        /*th {*/
        /*    padding-top: 12px;*/
        /*    padding-bottom: 12px;*/
        /*    text-align: left;*/
        /*    background-color: #04AA6D;*/
        /*    color: white;*/
        /*}*/

        #createForm1 .submit  {

            margin-left: 30%;
            align-items: center;
        }
        #createForm1{

            margin-top: 35px;
            margin-left: 50%;
            transform: translateX(-50%);
            width: 60%;
        }
    </style>
</head>
<body>
<%@include file="../header.jsp" %>
<form id="createForm1" action="/book?action=muon&id=${id}" method="post">
    <table>
        <tr>
            <th style="text-align: center" colspan="2">Mượn sách</th>
        </tr>
        <tr><td>Mã mượn sách</td>
            <td><input type="text"  name="idBook" value="${idBook}"></td>
        </tr>
        <tr>
            <td>Tên sách</td>
            <td hidden ><input  name="idSachMuon" value="${sach.maSach}"></td>
            <td>
                <c:if test="${sach.tenSach==null}">
                    ${sach.tenSach}
                </c:if>
                ${sach.tenSach}
<%--                <input  name="namedBook" value="${sach.tenSach}">--%>
<%--                <select id="tenSach" name="tenSach">--%>
<%--                    <c:forEach items="${sachList}" var="sachList" varStatus="status">--%>
<%--                        <option value="${sachList.maSach}" selected>${sachList.tenSach}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
            </td>
        </tr>
        <tr>
            <td>Tên học sinh</td>
            <td>
                <select id="tenHocSinh" name="tenHocSinh">
                    <c:forEach items="${hocSinhList}" var="c" varStatus="status">
                        <option value="${c.maHS}" selected>${c.hoTen}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Ngày mượn</td>
            <td><input type="date" name="dayIn" value="${dayIn}"></td>
        </tr>
        <tr>
            <td>Ngày trả</td>
            <td>
                <input type="date" name="dayOut" value="${dayOut}" >
                <p class="text-danger">${mess}</p>
            </td>

        </tr>

    </table>
    <div class="submit">
        <button class="btn btn-primary" type="submit">Mượn sách</button>
        <td>
            <%--                onclick="showDelete('${cus.customerId}','${cus.customerName}')"--%>
            <button type="button" class="btn btn-primary "
                    data-toggle="modal" data-target="#deleteForm">Hủy</button>
        </td>
    </div>
</form>


<div class="modal fade" id="deleteForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form>
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input hidden id="idCus1" name="idDelete1">
                    <span>Bạn có thoat khong? </span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                    <button type="button" class="btn btn-primary"><a style="text-decoration: none;color: white" href="/book">Thoát</a></button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
