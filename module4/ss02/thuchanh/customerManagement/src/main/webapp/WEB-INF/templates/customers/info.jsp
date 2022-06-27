<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 24/06/2022
  Time: 8:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="service.CustomerService" %>
<%@ page import="entity.Customer" %>
<%@ page import="service.impl.CustomerServiceImpl" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/customers" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="${customer.getId()}">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    ${customer.getId()}
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${customer.getName()}">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" name="email" value="${customer.getEmail()}">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" value="${customer.getAddress()}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customers">Back to list</a>.
</body>
</html>
