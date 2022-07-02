<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khai báo y tế</title>
</head>
<body>
<h2>Khai báo y tế</h2>
<form:form method="post" modelAttribute="medical">
    <table border="1px">
        <tr>
            <th>Họ và tên:</th>
            <td><form:input type="text" path="name"/></td>

        </tr>
        <tr>
            <th>Năm sinh:</th>
            <td><form:input type="number" path="birth"/></td>

        </tr>
        <tr>
            <th>Giới tính:</th>
            <td>
                <form:select  path="gender">
                    <form:option value="Nam">Nam</form:option>
                    <form:option value="Nữ">Nữ</form:option>
                    <form:option value="Khác">Khác</form:option>
                </form:select>
            </td>

        </tr>
        <tr>
            <th>Quốc tịch:</th>
            <td><form:input type="text" path="nation"/></td>

        </tr>
        <tr>
            <th>Chứng minh nhân dân:</th>
            <td><form:input type="text" path="id"/></td>

        </tr>
        <tr>
            <th>Thông tin đi lại:</th>
            <td>
                <form:radiobutton path="transport" value="Tàu bay"/> Tàu bay
                <form:radiobutton path="transport" value="Tàu thuyền"/> Tàu thuyền
                <form:radiobutton path="transport" value="Ô tô"/> Ô tô
                <form:radiobutton path="transport" value="Khác"/> Khác
            </td>

        </tr>
        <tr>
            <th>Số hiệu phương tiện:</th>
            <td><form:input type="text" path="licensePlate"/></td>

        </tr>
        <tr>
            <th>Ngày khởi hành:</th>
            <td><form:input type="date" path="startDay"/></td>

        </tr>
        <tr>
            <th>Ngày kết thúc:</th>
            <td><form:input type="date" path="endDay"/></td>

        </tr>
        <tr>
            <th>Trong 14 ngày, anh chị đi những đâu</th>
            <td><form:textarea rows="5" cols="100" path="route"/></td>
        </tr>
            <%--        <tr>--%>
            <%--            <input type="submit" value="Gửi khai báo">--%>
            <%--        </tr>--%>
    </table>
    <div>
        <input type="submit" value="Gửi khai báo">
    </div>
</form:form>
</body>
</html>