<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 27/02/2024
  Time: 2:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<html>
<head>
    <title>Title</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>--%>

    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />


</head>
<body>
<h1 style="text-align: center">EMPLOYEE</h1>


<form action="/employee" method="get">
    <input type="hidden" name="action" value="showFormAddUser">
    <input type="submit" role="button" class="btn btn-primary" value="Thêm Mới 1 Employee">
</form>
<table id="employeeTable" class="table table-striped table-bordered" style="width: 100%">
    <thead>
        <tr>
            <th>STT</th>
            <th>Tên Nhân Viên</th>
            <th>Ngày Sinh</th>
            <th>CMND</th>
            <th>Lương</th>
            <th>Số điện thoại</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Tai khoan</th>
            <th>Trình độ</th>
            <th>Vị Trí</th>
            <th>Vai Trò</th>
            <th>Cập Nhật</th>
            <th>Xóa </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="employee" items="${employeeList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${employee.employeeName}</td>
                <td>${employee.birthday}</td>
                <td>${employee.iDCard}</td>
                <td>${employee.salary}$</td>
                <td>${employee.numberPhone}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>${employee.userName}</td>
                <td>${employee.namePosition}</td>
                <td>${employee.nameDivition}</td>
                <td>${employee.nameEducation}</td>
                <td>
                    <form action="/employee"  method="get" >
                        <input type="hidden" name="action" value="showFormUpdate">
                        <input type="hidden" name="idUpdate" value="${employee.id}">
                        <input type="submit" role="button" value="UPDATE"   class="btn btn-primary" action="/employee?action=showFormUpdate">
                    </form>
                </td>
                <td>
                    <form action="/employee?action=deleteEmployee"  method="post" >
                        <input type="hidden" name="idDelete" value="${employee.id}">
                        <input type="submit" role="button" value="DELETE"   class="btn btn-primary">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%String messUpdate = request.getParameter("messUpdate");
    if (messUpdate == null){
        messUpdate = "";
    }
%>
<p><%=messUpdate%></p>
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap5.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#employeeTable').dataTable( {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            } );
        } );
</script>
</body>
</html>
