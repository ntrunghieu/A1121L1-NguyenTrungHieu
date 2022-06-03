<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/05/2022
  Time: 9:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--thu vien jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>

    <style>
        /*div {*/
        /*    width: 75%;*/
        /*    height: 100%;*/
        /*    text-align: center;*/
        /*    margin: auto;*/

        /*}*/

        table {
            margin-top: 30px;

        }
        .btn-create{
            margin: 7px;
        }
        h3{
            text-align: center;
            margin: 10px;
        }
        .table-area{
            width: 80%;
            margin: 0;
            left: 50%;
            transform: translateX(12%);
        }

    </style>
</head>
<body>

<%--  phan header cua trang--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/customers">CodeGym</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/customers">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" >
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            <button type="button" class="btn btn-outline-success my-2 my-sm-0 btn-create" data-toggle="modal" data-target="#createForm"
                    onclick="showCreate('${cus.id}','${cus.name}','${cus.email}','${cus.address}')">Create
            </button>
        </form>
    </div>
</nav>

<h3>Danh sách sinh viên</h3>


<%--<button type="button"><span><a href="/customers?action=create" class="link1">Create a new customer</a></span></button>--%>
<table border="1" style="border-collapse:  collapse" class="table table-area">
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    <c:forEach items="${customers}" var="cus" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td><a href="/customers?action=view&id=${cus.getId()}">${cus.id}</a></td>
            <td><a href="/customers?action=view&id=${cus.getName()}">${cus.name}</a></td>
            <td>${cus.email}</td>
            <td>${cus.address}</td>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editForm"
                        onclick="showEdit('${cus.id}','${cus.name}','${cus.email}','${cus.address}')">Edit
                </button>
<%--                <button type="button"><a href="/customers?action=edit&id=${cus.getId()}">Edit</a></button>--%>
            </td>
            <td>
                <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#deleteForm"
                        onclick="showDelete('${cus.id}','${cus.name}')">Delete</a>
                </button>
            </td>


                <%--Lấy thông tin tên lớp--%>
                <%--            <c:forEach items="${classCGList}" var="cls">--%>
                <%--                <c:if test="${cls.id==student.classId}">--%>
                <%--                    <td>${cls.name}</td>--%>
                <%--                </c:if>--%>
                <%--            </c:forEach>--%>
                <%--            <td><c:out value="${student.email}"></c:out></td>--%>
        </tr>
    </c:forEach>
</table>


<%-- modal xoa khach hang--%>

<div class="modal fade" id="deleteForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customers?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input hidden type="number" id="idCus1" name="idDelete1">
                    <span>Bạn có muốn xóa khach hang </span>
                    <span class="text-danger" id="nameCus1"></span> không?<span/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>


<%--    modal tao khach hang--%>
<div class="modal fade" id="createForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customers?action=create" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-tittle">Create a new customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="idCus2"></label>
                        <input type="text" class="form-control" id="idCus2" placeholder="Your ID" name="id">
                    </div>

                    <div class="form-group">
                        <label for="nameCus2"></label>
                        <input type="text" class="form-control" id="nameCus2" placeholder="Name" name="name" >
                    </div>

                    <div class="form-group">
                        <label for="emailCus2"></label>
<%--                        pattern="^[a-z]\\w+@gmail+\\.[a-z]+$"--%>
                        <input type="text" class="form-control" id="emailCus2" placeholder="name@gmail.com" name="email"  title="name@gmail.com">
                    </div>

                    <div class="form-group">
                        <label for="addressCus2"></label>
                        <input type="text" class="form-control" id="addressCus2" placeholder="Address" name="address">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%--    modal chinh sua khach hang--%>
<div class="modal fade" id="editForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customers?action=edit" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-tittle-edit">Edit customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="idCus2"></label>
                        <input hidden type="text" class="form-control" id="idCus3" placeholder="Your ID" name="id">
                    </div>

                    <div class="form-group">
                        <label for="nameCus2"></label>
                        <input type="text" class="form-control" id="nameCus3" placeholder="Name" name="name" >
                    </div>

                    <div class="form-group">
                        <label for="emailCus2"></label>
                        <%--                        pattern="^[a-z]\\w+@gmail+\\.[a-z]+$"--%>
                        <input type="text" class="form-control" id="emailCus3" placeholder="name@gmail.com" name="email"  title="name@gmail.com">
                    </div>

                    <div class="form-group">
                        <label for="addressCus2"></label>
                        <input type="text" class="form-control" id="addressCus3" placeholder="Address" name="address">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Edit</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script>
    function showDelete(id, name) {
        document.getElementById("idCus1").value = id;
        document.getElementById("nameCus1").innerText = name;

    }

    function showCreate(id, name,email,address) {
        document.getElementById("idCus2").value = id;
        document.getElementById("nameCus2").innerHTML = name;
        document.getElementById("emailCus2").innerHTML = email;
        document.getElementById("addressCus2").innerHTML = address;
    }
    function showEdit(id, name,email,address) {
        document.getElementById("idCus3").value = id;
        document.getElementById("nameCus3").value = name;
        document.getElementById("emailCus3").value = email;
        document.getElementById("addressCus3").value = address;
    }
</script>