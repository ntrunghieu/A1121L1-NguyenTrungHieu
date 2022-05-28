<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/05/2022
  Time: 6:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <p>
        <a href="/products">Back to customer list</a>
    </p>

    <form method="post">
        <fieldset>
            <legend>Customer information</legend>
            <table>
                <tr>
                    <td>Id: </td>
                    <td><input type="text" name="id" id="id"></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="text" name="price" id="price"></td>
                </tr>
                <tr>
                    <td>Description </td>
                    <td><input type="text" name="description" id="description"></td>
                </tr>
                <tr>
                    <td>Manufacturer </td>
                    <td><input type="text" name="manufacturer" id="manufacturer"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
