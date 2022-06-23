<%@ page import="model.bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 08/06/2022
  Time: 8:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>
    <style>
        html {
            font-family: "Helvetica Neue", Arial, sans-serif;
        }

        /** {*/
        /*    margin: 0;*/
        /*    padding: 0;*/
        /*    box-sizing: border-box;*/
        /*}*/

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

        #nav .nav-name li {
            /*display: inline-block;*/
        }

        #nav li a {
            /*color: #cbbfbf;*/
            /*text-decoration: none;*/
            /*line-height: 68px;*/
            /*left: 80%;*/
        }

        .nav-name li :hover a {
            /*color: #272882;*/
            /*background-color: #ccc;*/

        }

        #nav .nav-name .subnav {
            /*display: none;*/
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




        /*.name {*/
        /*    color: white;*/
        /*    right: 50%;*/
        /*    display: inline-block;*/
        /*}*/
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
    </style>
</head>
<body>
<div id="nav" class="header col-12 ">
    <div class=" nav-logo">
        <img src="codegym.png" style="width: 40px;height: 40px">
    </div>
    <div class=" nav-name">
        <a><span class="text-white"><%=session.getAttribute("sessionUser")!=null?((Account)session.getAttribute("sessionUser")).getUsername():""%></span></a>
        <%--        <a href="#">Nguyen Trung Hieu</a>--%>
        <%--        <ul class="subnav">--%>
        <%--            <li><a href="">Dashboard</a></li>--%>
        <%--            <li><a href="">Profile</a></li>--%>
        <%--            <li><a href="">Log out</a></li>--%>
        <%--        </ul>--%>
    </div>


</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light">


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul style="margin-left: 200px" class="navbar-nav mr-auto margin-navbar ">
            <li class="nav-item active">
                <a class="nav-link" href="/book">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/danhSachMuon">Danh sách mượn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/hocsinh">Quản lý học sinh</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/book">Quản lý sách</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contract</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-expanded="false">
                    Sort
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Name</a>
                    <a class="dropdown-item" href="#">Email</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Address</a>
                </div>
            </li>
        </ul>
        <form action="/hocsinh?action=search" class="form-inline my-2 my-lg-0" method="post">
            <input value="${nameSearch}" name="nameSearch" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button name="action" value="search" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <%--            onclick="showCreate('${cus.id}','${cus.typeId}','${cus.name}','${cus.birthday}','${cus.gender}','${!cus.gender}',--%>
        <%--            '${cus.idCard}','${cus.phone}','${cus.email}','${cus.address}')"--%>
<%--        <form action="/hocsinh?action=create" class="form-inline my-2 my-lg-0" method="get">--%>
<%--            <input hidden name="action" value="create">--%>
<%--            <button type="submit" class="btn btn-outline-success my-2 my-sm-0 btn-create"--%>
<%--                    data-toggle="modal" data-target="#createForm">Create</button>--%>
<%--            &lt;%&ndash;            <a href="/admin?action=create">Create</a>&ndash;%&gt;--%>
<%--        </form>--%>
    </div>
</nav>

<div id="mySidebar" class="sidebar">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
    <a href="#">About</a>
    <a href="#">Services</a>
    <a href="#">Clients</a>
    <a href="#">Contact</a>
</div>

<div id="main">
    <button class="openbtn" onclick="openNav()">☰</button>
    <!--    <h2>Collapsed Sidebar</h2>-->
    <!--    <p>Click on the hamburger menu/bar icon to open the sidebar, and push this content to the right.</p>-->
</div>

<script>
    function openNav() {
        document.getElementById("mySidebar").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
    }

    function closeNav() {
        document.getElementById("mySidebar").style.width = "0";
        document.getElementById("main").style.marginLeft= "0";
    }
</script>
</body>

</html>
