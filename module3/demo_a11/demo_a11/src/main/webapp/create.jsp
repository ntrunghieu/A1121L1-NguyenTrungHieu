<%--
  Created by IntelliJ IDEA.
  User: LENOVO PC
  Date: 6/13/2022
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<form method="post">
    <div class="mb-3">
        <label class="form-label">Name</label>
        <input type="text" name="name" value="${customer.name}" class="form-control" >
        <small style="color: red"> ${errorMap.name}  </small>
    </div>
    <div class="mb-3">
        <label class="form-label">Address</label>
        <input type="text" value="${customer.address}" name="address" class="form-control" >
        <small style="color: red"> ${errorMap.address}  </small>
    </div>
    <select name="idCustomerType" >
        <c:forEach items="${customerTypeList}" var="item">
            <c:if test="${customer.idCustomerType == item.id}">
                <option value="${item.id}" selected> ${item.name}</option>
            </c:if>
            <c:if test="${customer.idCustomerType != item.id}">
                <option value="${item.id}"> ${item.name}</option>
            </c:if>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>
