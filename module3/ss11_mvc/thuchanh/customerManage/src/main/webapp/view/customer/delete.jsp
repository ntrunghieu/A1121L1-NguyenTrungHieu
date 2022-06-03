<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 25/05/2022
  Time: 7:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["customer"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["customer"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${requestScope["customer"].getAddress()}</td>
            </tr>
            <tr>
                <td><button type="submit" value="Delete customer"></button></td>
                <td><button type="button"><a href="/customers">Back to customer list</a><span></span></button></td>
            </tr>
        </table>
    </fieldset>
</form>

<%--<form method="post">--%>
<%--<div class="modal fade" tabindex="-1" id="myModal">--%>
<%--    <div class="modal-dialog modal-sm">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title">Are you sure?</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <fieldset>--%>
<%--                    <legend>Customer information</legend>--%>
<%--                    <table>--%>
<%--                        <tr>--%>
<%--                            <td>Name: </td>--%>
<%--                            <td>${requestScope["customer"].getName()}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Email: </td>--%>
<%--                            <td>${requestScope["customer"].getEmail()}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Address: </td>--%>
<%--                            <td>${requestScope["customer"].getAddress()}</td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
<%--                </fieldset>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                <button type="submit" class="btn btn-primary"><a href="/customers">Save</a></button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</form>--%>
</body>
</html>
