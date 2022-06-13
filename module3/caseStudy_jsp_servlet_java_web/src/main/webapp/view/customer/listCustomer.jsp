<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 09/06/2022
  Time: 11:57 SA
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
            margin-top: 60px;
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
        <th>Type</th>
        <th>Username</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>ID Card</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCustomer}" var="cus" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${cus.customerId}</td>
            <c:if test="${cus.customerTypeId==1}">
                <td>Diamond</td>
            </c:if>
            <c:if test="${cus.customerTypeId==2}">
                <td>Platinium</td>
            </c:if>
            <c:if test="${cus.customerTypeId==3}">
                <td>Gold</td>
            </c:if>
            <c:if test="${cus.customerTypeId==4}">
                <td>Silver</td>
            </c:if>
            <c:if test="${cus.customerTypeId==5}">
                <td>Member</td>
            </c:if>
            <td>${cus.customerName}</td>
            <td>${cus.customerBirthday}</td>
            <td>${cus.customerGender}</td>
<%--            <c:if test="${cus.gender==0}">--%>
<%--                <td>Male</td>--%>
<%--            </c:if>--%>
<%--            <c:if test="${cus.gender==1}">--%>
<%--                <td>Female</td>--%>
<%--            </c:if>--%>
            <td>${cus.customerIdCard}</td>
            <td>${cus.customerPhone}</td>
            <td>${cus.customerEmail}</td>
            <td>${cus.customerAddress}</td>
            <td>
<%--                onclick="showEdit('${cus.id}',${cus.typeId},'${cus.name}','${cus.birthday}','${cus.gender}',--%>
<%--                '${cus.idCard}','${cus.phone}','${cus.email}','${cus.address}')"--%>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editForm"><a href="/admin?action=edit&id=${cus.getCustomerId()}">Edit</a></button>
            </td>
            <td>
<%--                onclick="showDelete('${cus.customerId}','${cus.customerName}')"--%>
                <button type="button" class="btn btn-primary "
                        data-toggle="modal" data-target="#deleteForm" onclick="showDelete('${cus.customerId}','${cus.customerName}')">Delete</button>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<%-- modal xoa khach hang--%>
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
                    <input hidden type="text" id="idCus1" name="idDelete1">
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


<%--modal them khach hang--%>
<%--<div class="modal fade" id="createForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <form action="/admin?action=create" method="post">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="modal-tittle">Create a new customer</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <div hidden class="form-group">--%>
<%--                        <label hidden for="idCus2">ID</label>--%>
<%--                        <input hidden type="text" class="form-control" id="idCus2" placeholder="Your ID" name="id2">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="type">Type</label>--%>
<%--                        <select id="type" name="typeCus2">--%>
<%--                            <c:forEach items="${customerTypeList}" var="c" varStatus="status">--%>
<%--                                <option value="${status.count}">${c.nameCustomerType}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="nameCus2"></label>--%>
<%--                        <input type="text" class="form-control" id="nameCus2" placeholder="Name" name="name">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="birthday2"></label>--%>
<%--                        <input type="text" class="form-control" id="birthday2" placeholder="Birthday" name="birthday">--%>
<%--                    </div>--%>

<%--                    &lt;%&ndash;                    <div class="form-group">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input type="radio" class="form-control" id="genderNam" placeholder="gender" name="gender" value="true"> Male&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input type="radio" class="form-control" id="genderNu" placeholder="gender" name="gender" value="true" > Female&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="gender">Gender</label>--%>
<%--                        <select id="gender" name="gender">--%>
<%--                            <option value="0">Male</option>--%>
<%--                            <option value="1">Female</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>


<%--                    &lt;%&ndash;                    <div class="btn-group btn-group-toggle" data-toggle="buttons">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <label class="btn btn-secondary active">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                            <input type="radio" name="gender" id="genderNam" value="true" checked> Male&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        </label>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <label class="btn btn-secondary">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                            <input type="radio" name="gender" id="genderNu" value="false"> Female&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        </label>&ndash;%&gt;--%>

<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="idCard2"></label>--%>
<%--                        <input type="text" class="form-control" id="idCard2" placeholder="ID CARD" name="idCard">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="phone2"></label>--%>
<%--                        <input type="text" class="form-control" id="phone2" placeholder="phone" name="phone">--%>
<%--                    </div>--%>


<%--                    <div class="form-group">--%>
<%--                        <label for="emailCus2"></label>--%>
<%--                        &lt;%&ndash;                        pattern="^[a-z]\\w+@gmail+\\.[a-z]+$"&ndash;%&gt;--%>
<%--                        <input type="text" class="form-control" id="emailCus2" placeholder="name@gmail.com" name="email"--%>
<%--                               title="name@gmail.com">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="addressCus2"></label>--%>
<%--                        <input type="text" class="form-control" id="addressCus2" placeholder="Address" name="address">--%>
<%--                    </div>--%>

<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Create</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>


<%--modal chinh sua kh--%>
<%--<div class="modal fade" id="editForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <form action="/admin?action=edit" method="post">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="modal-tittle-edit">Edit customer</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="idCus3"></label>--%>
<%--                        <input hidden type="text" class="form-control" id="idCus3" placeholder="Your ID" name="id">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label ></label>--%>
<%--                        <input type="text" class="form-control" id="typeCus3" placeholder="Type" name="typeCus">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label ></label>--%>
<%--                        <input type="text" class="form-control" id="nameCus3" placeholder="Name" name="name">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="birthday3"></label>--%>
<%--                        <input type="text" class="form-control" id="birthday3" placeholder="birthday" name="birthday">--%>
<%--                    </div>--%>
<%--                    &lt;%&ndash;                    <div class="form-group">&ndash;%&gt;--%>

<%--                    <div class="btn-group btn-group-toggle" data-toggle="buttons">--%>
<%--                        <label class="btn btn-secondary active">--%>
<%--                            <input type="radio" name="options" id="option" checked> Active--%>
<%--                        </label>--%>
<%--                        <label class="btn btn-secondary">--%>
<%--                            <input type="radio" name="options" id="option2"> Radio--%>
<%--                        </label>--%>
<%--                    </div>--%>

<%--                    &lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input type="radio" class="form-control" id="genderNam1" placeholder="gender" name="gender" value="true"> Male&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input type="radio" class="form-control" id="genderNu1" placeholder="gender" name="gender" value="true" > Female&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="idCard3"></label>--%>
<%--                        <input type="text" class="form-control" id="idCard3" placeholder="ID CARD" name="idCard">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="phone3"></label>--%>
<%--                        <input type="text" class="form-control" id="phone3" placeholder="Phone" name="phone">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="emailCus3"></label>--%>
<%--                        &lt;%&ndash;                        pattern="^[a-z]\\w+@gmail+\\.[a-z]+$"&ndash;%&gt;--%>
<%--                        <input type="text" class="form-control" id="emailCus3" placeholder="name@gmail.com"--%>
<%--                               name="email"--%>
<%--                               title="name@gmail.com">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label for="addressCus3"></label>--%>
<%--                        <input type="text" class="form-control" id="addressCus3" placeholder="Address"--%>
<%--                               name="address">--%>
<%--                    </div>--%>

<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Edit</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>


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