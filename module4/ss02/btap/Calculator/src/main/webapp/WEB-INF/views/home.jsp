<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 24/06/2022
  Time: 7:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Calculator</h2>
<form action="/result" method="post">
    <div>
        <label for="num1">Number 1: </label>
        <input type="number" name="num1" id="num1" >
    </div>
    <div>
        <label for="num2">Number 2: </label>
        <input type="number" name="num2" id="num2" >
        <br>
        <h5 style="color: red"><c:if test="${mess != null}">${mess}</c:if></h5>

    </div>
    <br>
    <button type="submit" name="Submit" value="cong">Cong</button>
    <button type="submit" name="Submit" value="tru">Tru</button>
    <button type="submit" name="Submit" value="nhan">Nhan</button>
    <button type="submit" name="Submit" value="chia">Chia</button>
</form>
<h4>Sum: ${sum}</h4>


</body>
</html>
