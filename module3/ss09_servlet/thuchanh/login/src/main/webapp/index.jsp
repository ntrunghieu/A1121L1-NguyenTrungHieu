<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/05/2022
  Time: 2:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<style type="text/css">
  .login {
    height:180px; width:250px;
    margin:0;
    padding:10px;
    border:1px #CCC solid;
  }
  .login input {
    padding:5px; margin:5px
  }
</style>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <form method="get" action="/login">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="username" size="30"  placeholder="username" />
      <input type="password" name="password" size="30" placeholder="password" />
      <input type="submit" value="Sign in"/>
    </div>
  </form>
  </body>
</html>
