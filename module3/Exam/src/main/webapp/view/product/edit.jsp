<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/06/2022
  Time: 10:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="../../jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../../bootstrap4.6.0/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="../../bootstrap4.6.0/css/bootstrap.min.css">
    <script src="../../bootstrap4.6.0/js/bootstrap.min.js"></script>

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

<form id="createForm1" action="/product?action=edit" method="post">
    <table>
        <tr>
            <th style="text-align: center" colspan="2">Edit product</th>
        </tr>
        <tr>
            <td>Tên sản phẩm: </td>
            <td><input type="text"  name="tenSP" value="${product.tenSanPham}"></td>
        </tr>
        <tr>
            <td>Giá: </td>
            <td><input type="text" name="gia" value="${product.gia}"></td>
        </tr>
        <tr>
            <td>Số lượng: </td>
            <td><input type="text" name="soLuong" value="${product.soLuong}"></td>
        </tr>
        <tr>
            <td>Màu: </td>
            <td><input type="text" name="mau" value="${product.mau}" ></td>
        </tr>
        <tr>
            <td>Phân loại</td>
            <td>
                <select id="loai" name="loai">
                    <c:forEach items="${categoryList}" var="type" varStatus="status">
                        <option value="${type.maCategory}" selected>${type.tenCategory}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

    </table>
    <div class="submit">
        <button class="btn btn-primary" type="submit">Lưu</button>
        <td>
            <%--                onclick="showDelete('${cus.customerId}','${cus.customerName}')"--%>
            <button type="button" class="btn btn-primary "
                    data-toggle="modal" data-target="#deleteForm">Quay lại</button>
        </td>
    </div>
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
                    <span>Bạn có muốn thoat khong? </span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                    <button type="button" class="btn btn-primary"><a style="text-decoration: none;color: white" href="/product">Thoát</a></button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
