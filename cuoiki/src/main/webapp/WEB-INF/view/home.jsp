<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 25/11/2022
  Time: 8:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../resources/bootstrap4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/datatables/css/dataTables.bootstrap4.min.css" />
    <style>
        html {
            font-family: "Helvetica Neue", Arial, sans-serif;
        }

        .header {
            height: 68px;
            background-color: #272882;
        }

        #nav .nav-logo img {
            margin: 13px;
        }

        #nav .nav-name {

            line-height: 68px;

        }
        div#nav:hover{
            background-color: #343590;

        }

        #nav .nav-name a {
            right: 50%;
            color: white;
        }



        #header img {
            margin: 13px;
        }
        div#nav{
            display: flex;
        }
        #nav .nav-name{
            margin-left: 70%;
        }


        body {
            font-family: "Lato", sans-serif;
        }

        .sidebar {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 100;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidebar a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .sidebar a:hover {
            color: #f1f1f1;
        }

        .sidebar .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        .openbtn {
            font-size: 20px;
            cursor: pointer;
            background-color: #111;
            color: white;
            padding: 10px 15px;
            border: none;
        }

        .openbtn:hover {
            background-color: #444;
        }

        #main {
            transition: margin-left .5s;
            padding: 16px;
        }
        div#mySidebar{

            margin-top: 68px;
        }

        /* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
        @media screen and (max-height: 450px) {
            .sidebar {padding-top: 15px;}
            .sidebar a {font-size: 18px;}
        }
        div#main button{
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }
        div#nav{
            position: -webkit-sticky;
            position: sticky;
            top: 0;
            z-index: 100;
        }

        nav.navbar div.collapse ul li{
            display: flex;
            list-style: none;
        }
        .btn{
            margin-top: 1rem;
            display:inline-block;
            padding:.9rem 3rem;
            border-radius: .5rem;
            color:black;
            background:var(--green);
            font-size: 1.0rem;
            cursor: pointer;
            font-weight: 500;
        }

        .btn:hover{
            background-color: #219150;
        }
    </style>
</head>
<body>
<div id="nav" class="header col-12 ">
    <div class=" nav-logo">
<%--        <img src="../../codegym.jpg" style="width: 40px;height: 40px">--%>
    </div>
    <div class=" nav-name">
        <a><span>Dương</span></a>
<%--        <a><span class="text-white"><%=session.getAttribute("sessionUser")!=null?((Account)session.getAttribute("sessionUser")).getUsername():""%></span></a>--%>
        <%--        <a href="#">Nguyen Trung Hieu</a>--%>
        <%--        <ul class="subnav">--%>
        <%--            <li><a href="">Dashboard</a></li>--%>
        <%--            <li><a href="">Profile</a></li>--%>
        <%--            <li><a href="">Log out</a></li>--%>
        <%--        </ul>--%>
    </div>
</div>


<div id="mySidebar" class="sidebar">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
    <a href="#">About</a>
    <a href="#">Services</a>
    <a href="#">Clients</a>
    <a href="#">Contact</a>
</div>

<div id="main">
    <button class="openbtn" onclick="openNav()">☰</button>
</div>



<a href="/admin/book-create" class="btn">Thêm mới sách</a>
<div align="center" class="container">
    <table id="tableStudent" class="table table-area" border="1" style="border-collapse:  collapse" >
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã code</th>
            <th scope="col">Tên sách</th>
            <th scope="col">Tác giả</th>
            <th scope="col">NXB</th>
            <th scope="col">Nội dung</th>
            <th scope="col">Gía</th>
            <th scope="col">Loại sách</th>
            <th scope="col">Chức năng</th>

        </tr>
        <c:forEach items="${listBook}" var="book" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td><a href="/users?action=view&id=${book.bookId}">${book.bookCode}</a></td>
                <td><a href="/users?action=view&id=${book.bookId}">${book.bookName}</a></td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookPublisher}</td>
                <td>${book.bookContent}</td>
                <td>${book.bookPrice}</td>
                <td>${book.bookCategoryId.categoryName}</td>
                <td>
                    <a hidden style="width: 88px" class="btn btn-primary " href="/admin/book-detail/${book.bookId}">Chi tiết</a>
                    <a style="width: 88px" class="btn btn-primary " href="/admin/book-edit/${book.bookId}">Sửa</a>
<%--                    <button type="button"><span><a href="/admin/book-edit?id=${book.bookId}">Xóa</a></span>--%>
<%--                    </button>--%>
<%--                    <a class="btn btn-primary " href="/admin/book-delete/${book.bookId}"--%>
<%--                       onclick="return confirm('Ban co muon xoa sách' , ${book.bookName})">Xóa</a>--%>
                    <a style="width: 88px" href="/admin/book-delete/${book.bookId}" class="btn btn-primary "
                       onclick="return confirm('Ban co muon xoa sách này không')">Xóa</a>
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

<%-- modal xoa khach hang--%>
<div class="modal fade" id="deleteForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/admin?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input hidden type="text" id="idCus1" name="idDelete1">
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

</body>
</html>
<script src="../../resources/jquery/jquery-3.5.1.min.js"></script>
<script src="../../resources/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../resources/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });

    function openNav() {
        document.getElementById("mySidebar").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
    }

    function closeNav() {
        document.getElementById("mySidebar").style.width = "0";
        document.getElementById("main").style.marginLeft= "0";
    }
</script>
