<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/06/2022
  Time: 11:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <script src="jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>
    <style>
        body {
            height: 100%;
            background-size: 877px ;
            background-image:url(../loginCG.jpg);
            background-repeat: no-repeat;
        }

        body {
            display: -ms-flexbox;
            display: -webkit-box;
            display: flex;
            -ms-flex-align: center;
            -ms-flex-pack: center;
            -webkit-box-align: center;
            align-items: center;
            -webkit-box-pack: center;
            justify-content: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;

            margin-left: 890px;
        }

        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .checkbox {
            font-weight: 400;
        }
        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>
<body class="text-center">
<form class="form-signin " action="login" method="post">
    <fieldset>

        <img class="mb-4" src="codegym.png" alt="" width="72"
             height="72">
        <legend><h1 class="h3 mb-3 font-weight-normal">Please sign in</h1> </legend>
        <p class="text-danger">${messLogin}</p>
        <input value="${username}" name="username" type="text" id="inputEmail" class="form-control" placeholder="User name" required autofocus>
        <input value="${password}" name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </fieldset>
</form>

</body>
</html>
