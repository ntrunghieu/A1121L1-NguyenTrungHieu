<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/06/2022
  Time: 10:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>


    <style>
        table {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        /*th {*/
        /*    padding-top: 12px;*/
        /*    padding-bottom: 12px;*/
        /*    text-align: left;*/
        /*    background-color: #04AA6D;*/
        /*    color: white;*/
        /*}*/

        #createForm1 .submit  {

            margin-left: 30%;
            align-items: center;
        }
        #createForm1{

            margin-top: 35px;
            margin-left: 50%;
            transform: translateX(-50%);
            width: 60%;
        }
    </style>
</head>
<body>
<%@include file="../header.jsp" %>


<form id="createForm1" action="/admin?action=create" method="post">
    <table>
        <tr>
            <th colspan="2">Creat a new patient</th>
        </tr>
        <tr hidden>
            <td><input type="text" hidden name="id" ></td>
        </tr>
        <tr>
            <td>ID Record</td>
            <td><input type="text" name="idRecord" ></td>
        </tr>
        <tr>
            <td>ID Patient</td>
            <td><input type="text" name="idPatient" ></td>
            <small style="color: red"> ${errorMap.idPatient}  </small>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" ></td>
        </tr>
        <tr>
            <td>Day in</td>
            <td><input type="date" name="dayIn" ></td>
            <small style="color: red"> ${errorMap.date}  </small>
        </tr>
        <tr>
            <td>Day out</td>
            <td><input type="date" name="dayOut"></td>
        </tr>
        <tr>
            <td>Reason</td>
            <td><input type="text" name="reason" ></td>
        </tr>
    </table>
    <div class="submit">
        <button type="submit">Save</button>
        <button type="button"><a href="/admin">Back to list</a></button>
    </div>
</form>
</body>
</html>
