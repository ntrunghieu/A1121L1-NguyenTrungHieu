<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/05/2022
  Time: 11:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>

<%--<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabel">Xóa nhân viên!</h5>--%>
<%--            </div>--%>
<%--            <form action="/products?action=delete&id=${product.id}" method="post">--%>
<%--                <input type="hidden" name="action" value="delete">--%>
<%--                <input type="hidden" name="id" id="idDel">--%>
<%--                <div class="modal-body">--%>
<%--                    <p>Bạn có thật sự muốn xóa</p>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-danger">Delete</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>



<h4>Product information</h4>
    <table>
        <tr>
            <td>Id:</td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>${product.description}</td>
        </tr>
        <tr>
            <td>Brand:</td>
            <td>${product.manufacturer}</td>
        </tr>
        <tr>
            <td><a href="/products">Back to product list</a></td>
            <td></td>
        </tr>
    </table>
</body>
</html>
