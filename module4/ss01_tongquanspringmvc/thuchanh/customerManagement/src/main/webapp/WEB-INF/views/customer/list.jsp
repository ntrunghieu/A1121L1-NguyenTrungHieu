<%@ page import="model.service.CustomerService" %>
<%@ page import="model.service.impl.CustomerServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/06/2022
  Time: 8:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    private CustomerService customerService = new CustomerServiceImpl;
%>
<%
    long count = customerService.count();
    List<Customer> customers = customerService.findAll();
%>
<style>
    table {
        border: 1px solid #000;
    }
    th, td {
        border: 1px dotted #555;
    }
</style>
There are <%= count %> customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <% for (Customer c : customers) { %>
    <tr>
        <td>
            <%= c.getId() %>
        </td>
        <td>
            <a href="info.jsp?id=<%= c.getId() %>"><%= c.getName() %></a>
        </td>
        <td>
            <%= c.getEmail() %>
        </td>
        <td>
            <%= c.getAddress() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
