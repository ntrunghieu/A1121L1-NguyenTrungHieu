<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 23/05/2022
  Time: 3:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="/calculate" method="get">
    <fieldset style="width: 40%">
      <legend style="font-size: 24px">Calculator</legend>
      <label>First operand: </label>
      <input type="number" name="first_operand" value="0"> <br> <br>
      <label>Operator: </label>
      <select name="operator">
        <option name="+" value="+">Addition</option>
        <option name="-" value="-">Subtraction</option>
        <option name="*" value="*">Multiplication</option>
        <option name="/" value="/">Division</option>
      </select> <br> <br>
      <label>Last operand: </label>
      <input type="number" name="last_operand" value="0"> <br> <br>
      <input type="submit" value="Calculate">
    </fieldset>
  </form>
  </body>
</html>
