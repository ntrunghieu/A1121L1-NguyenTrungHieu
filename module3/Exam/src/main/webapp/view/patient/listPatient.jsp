<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/06/2022
  Time: 12:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            margin-top: 30px;

        }

        .btn-create {
            margin: 7px;
        }

        /*h3 {*/
        /*    text-align: center;*/
        /*    margin: 10px;*/
        /*}*/

        .table-area {
            width: 50%;
            margin-top: 10px;
            left: 50%;
            transform: translateX(7%);
        }
    </style>

</head>
<body>
<%@include file="../header.jsp" %>
<table id="tableStudent" class="table table-area" style="width: 80%">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Id</th>
        <th>Name</th>
        <th>Day in</th>
        <th>Day out</th>
        <th>Reason</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${patientList}" var="patient" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${patient.patient_id}</td>

            <td>${patient.name}</td>
            <td>${patient.day_in}</td>
            <td>${patient.day_out}</td>
            <td>${patient.reason}</td>
            <td>
                    <%--                onclick="showEdit('${cus.id}',${cus.typeId},'${cus.name}','${cus.birthday}','${cus.gender}',--%>
                    <%--                '${cus.idCard}','${cus.phone}','${cus.email}','${cus.address}')"--%>
                <button id="edit"  type="button" class="btn btn-primary" data-toggle="modal" data-target="#editForm">
                    <a style="color: white;text-decoration: none" href="/admin?action=edit&id=${patient.patient_id}">Edit</a>
                </button>
            </td>
            <td>
                    <%--                onclick="showDelete('${cus.customerId}','${cus.customerName}')"--%>
                <button type="button" class="btn btn-primary "
                        data-toggle="modal" data-target="#deleteForm" onclick="showDelete('${patient.patient_id}','${patient.name}')">Delete</button>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>



<div class="modal fade" id="deleteForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/admin?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input hidden id="idCus1" name="idDelete1">
                    <span>Bạn có muốn xóa khach hang </span>
                    <span class="text-danger" id="nameCus1"></span> không?<span/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>

</body>
</html>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>

    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });

    function showDelete(id, name) {
        document.getElementById("idCus1").value = id;
        document.getElementById("nameCus1").innerText = name;
    }

    // function showCreate(id, typeCus, name, birthday, genderMale, genderFemale, idCard, phone, email, address) {
    //     document.getElementById("id2").value = id;
    //     document.getElementById("typeCus2").innerText = typeCus;
    //     document.getElementById("nameCus2").innerText = name;
    //     document.getElementById("birthday2").innerText = birthday;
    //     document.getElementById("genderNam").innerText = genderMale;
    //     document.getElementById("genderNu").innerText = genderFemale;
    //
    //     document.getElementById("idCard2").innerText = idCard;
    //     document.getElementById("phone2").innerText = phone;
    //     document.getElementById("emailCus2").innerText = email;
    //     document.getElementById("addressCus2").innerText = address;
    // }

    // function showEdit(id, typeCus, name, birthday, gender, idCard, phone, email, address) {
    //     document.getElementById("idCus3").value = id;
    //     document.getElementById("typeCus3").value = typeCus;
    //     document.getElementById("nameCus3").value = name;
    //     document.getElementById("birthday3").value = birthday;
    //     document.getElementById("gender3").value = gender;
    //     document.getElementById("idCard3").value = idCard;
    //     document.getElementById("phone3").value = phone;
    //     document.getElementById("emailCus3").value = email;
    //     document.getElementById("addressCus3").value = address;
    // }
</script>