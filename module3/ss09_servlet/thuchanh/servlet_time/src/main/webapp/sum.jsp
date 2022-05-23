<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/05/2022
  Time: 2:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // code java
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    int s = n1+n2;
%>
<h1>Kết quả -jsp: <%=s%></h1>
</body>
</html>
