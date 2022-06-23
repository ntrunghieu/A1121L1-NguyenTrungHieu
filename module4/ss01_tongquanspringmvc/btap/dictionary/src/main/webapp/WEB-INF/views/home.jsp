<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/06/2022
  Time: 2:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Dictionary</h1>
</center>
<form action="/translate" method="post">
    <table class="table table-striped table-bordered">
        <tr>
            <th>
                <input type="text" class="form-control" name="search" placeholder="Enter your word">
            </th>
            <th>
                <button type="submit" class="btn btn-primary">Search</button>
            </th>
            <th>
                <h3>Result: ${result}</h3>
            </th>
        </tr>
    </table>
    <%--    <div class="form-group">--%>
    <%--        <input type="text" class="form-control" name="search" placeholder="Enter your word">--%>
    <%--    </div>--%>
    <%--    <center>--%>
    <%--    <button type="submit" class="btn btn-primary">Search</button>--%>
    <%--        <br>--%>
    <%--        <h3>Result: ${result}</h3>--%>
    <%--    </center>--%>

</form>
</body>
</html>
