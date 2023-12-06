<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/11/2022
  Time: 3:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" contentType="text/html;charset=UTF-8" >
</head>
<body>
<center>
    <h1>Trang này của Admin</h1>
    <h2>
        <a href="/home">Quản lý sách</a>
    </h2>
</center>
<div align="center" class="container">
    <form:form action="/admin/book-update" method="post" modelAttribute="book" >
        <table border="1" cellpadding="5">
            <caption>
                <h2>Sửa đổi sách</h2>
            </caption>
            <tr>
                <th>Tên sách</th>
                <td hidden> <form:input value="${book.bookId}" type="text" name="bookId"  id="bookId"  path="bookId"/></td>
                <td>
                    <form:input value="${book.bookName}" type="text" name="bookName"  id="bookName"  path="bookName"/>

                </td>
            </tr>
            <tr>
                <th>Mã sách</th>
                <td>
                    <form:input type="text" name="bookCode" id="bookCode"  path="bookCode"/>
                </td>
            </tr>
            <tr>
                <th>Loại sách:</th>
                <td>
                    <form:select name="category" id="category" path="bookCategoryId.categoryId">
                        <c:forEach var="cate" items="${category}" varStatus="status">
                            <option selected value="${cate.categoryId}">${cate.categoryName}</option>
                        </c:forEach>

                    </form:select>
                </td>
            </tr>
            <tr>
                <th>Chọn ảnh:</th>
                <td>
                    <form:input type="file" name="bookImage" accept="image/*"  id="bookImage"  path="bookImage"/>
                </td>
            </tr>
            <tr>
                <th>Nội dung:</th>
                <td>
                    <form:textarea cols="30" rows="15"  type="text" name="country" id="country" size="15" path="bookContent"/>
                </td>
            </tr>
            <tr>
                <th>Gía:</th>
                <td>
                    <form:input type="number" name="bookPrice" id="bookPrice" min="1" path="bookPrice"/>
                </td>
            </tr>
            <tr>
                <th>Nhà biên soạn:</th>
                <td>
                    <form:input type="text" name="bookTranslator" id="bookTranslator" path="bookTranslator"/>
                </td>
            </tr>
            <tr>
                <th>Số lượng:</th>
                <td>
                    <form:input type="text" name="bookQuantity" id="bookQuantity" path="bookQuantity"/>
                </td>
            </tr>
            <tr>
                <th>NXB:</th>
                <td>
                    <form:input type="text" name="bookPublisher" id="bookPublisher"  path="bookPublisher"/>
                </td>
            </tr>
            <tr>
                <th>Tác giả:</th>
                <td>
                    <form:input type="text" name="bookAuthor" id="bookAuthor"  path="bookAuthor"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Lưu"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
