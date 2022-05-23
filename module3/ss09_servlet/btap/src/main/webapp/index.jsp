<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/05/2022
  Time: 1:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      body {
        width: 30%;
        margin: auto;
        background-color: lightgoldenrodyellow;
        border: 1px solid;
      }

      input {
        display: block;

        margin-top: 6px;
        margin-bottom: 6px;
        margin-left: 27%;
      }

      h1 {
        text-align: center;
      }

      div {
        display: block;
        text-align: center;
        font-size: 20px;
        font-weight: bold;

      }
      #submit{
        margin-left: 40%;
        margin-top: 6px;
      }
    </style>
  </head>

  <body>
  <h1>Product Discount Calculator</h1>
  <a href="/calculate?ProductName=abc&ListPrice=10000&DiscountPercent=10"></a>
  <form method="post" action="/display-discount">
    <div>
      <label for="product_name">Product Name: </label>
      <input type="text" name="product_name" id="product_name" placeholder="Enter product name: "> <br>

    </div>
    <div>
      <lable for="list_price">List Price:</lable>
      <input type="number" name="list_price" id="list_price" placeholder="Enter price"> <br>

    </div>
    <div>
      <lable for="discount_percent">Discount Percent</lable>
      <input type="number" name="discount_percent" id="discount_percent"> <br>
    </div>
    <input type="submit" value="Calculate" id="submit">
  </form>
  </body>
</html>
