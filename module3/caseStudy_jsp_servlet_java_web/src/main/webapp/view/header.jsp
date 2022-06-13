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
        <ul class="navbar-nav mr-auto margin-navbar ">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Service</a>
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
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>

<%--            onclick="showCreate('${cus.id}','${cus.typeId}','${cus.name}','${cus.birthday}','${cus.gender}','${!cus.gender}',--%>
<%--            '${cus.idCard}','${cus.phone}','${cus.email}','${cus.address}')"--%>
            <button type="button" class="btn btn-outline-success my-2 my-sm-0 btn-create"
                    data-toggle="modal" data-target="#createForm"><a href="/admin?action=create">Create</a></button>
        </form>
    </div>
</nav>

<div class="foot"></div>
</body>
</html>
