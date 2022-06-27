<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 24/06/2022
  Time: 7:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Sandwich condiments</h2>
<form action="/result" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Spouts">Spouts
    <br>
    <button type="submit">Save</button>
</form>

<h4>Resul: ${output}</h4>


</body>
</html>
