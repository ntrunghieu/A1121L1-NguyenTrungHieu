<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    DataTables 1.10.21 support bootstrap <= 4.1.3--%>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Date of birth</th>
                            <th>Mark</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${studentListAbc}">
                            <tr>
                                <td><c:out value="${student.id}"></c:out></td>
                                <td><c:out value="${student.name}"></c:out></td>
                                <td><c:out value="${student.dateOfBirth}"></c:out></td>
                                <td><c:out value="${student.mark}"></c:out></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap4.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#tableStudent').dataTable( {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            } );
        } );
    </script>
</body>
</html>
