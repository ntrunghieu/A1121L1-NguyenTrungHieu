<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/05/2022
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <h1> Currency Converter </h1>
  <form action="/convert" method="post">
    <lable>Rate: </lable>
    <br>
    <input type="text" value="22000" name="rate"> <br>
    <lable>USD</lable>
    <br>
    <input type="text" value="0" name="usd"> <br>
    <input type="submit" value="Converter">
  </form>
  </body>
</html>
