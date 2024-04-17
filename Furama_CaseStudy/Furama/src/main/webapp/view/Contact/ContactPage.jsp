<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 06/03/2024
  Time: 7:51 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
</head>
<body>
<h1 style="text-align: center">EMPLOYEE</h1>


<form action="/employee" method="get">
    <input type="hidden" name="action" value="showFormAddUser">
    <input type="submit" role="button" class="btn btn-primary" value="Thêm Mới 1 Employee">
</form>
<table id="contactTable" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ngay Lam Hop Dong</th>
        <th>Ngay Ket thuc hop Dong</th>
        <th>Tien Dat coc</th>
        <th>Tên Nhân viên</th>
        <th>Tên Khách hàng</th>
        <th>Tên dịch vụ</th>
        <th>Cập Nhật</th>
        <th>Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contact" items="${ContactList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${contact.startDate}</td>
            <td>${contact.endDate}</td>
            <td>${contact.money}</td>
            <td>${contact.employeeName}$</td>
            <td>${contact.customerName}</td>
            <td>${contact.serviceName}</td>
            <td>
                <form action="/contact"  method="get" >
                    <input type="hidden" name="action" value="/contact?action=showFormUpdate">
                    <input type="hidden" name="idUpdate" value="${contact.contactId}">
                    <input type="submit" role="button" value="UPDATE"   class="btn btn-primary">
                </form>
            </td>
            <td>
                <button type="button" class="btn btn-primary" onclick="deleteContact('${contact.contactId}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        DELETE
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%String messUpdate = request.getParameter("messDelete");
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
        $('#contactTable').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );

    function deleteContact(id) {
        document.getElementById("idDelete").value = id;
    }
</script>


<div class="modal" id="exampleModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <form action="/contact?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Delete one contact !</h1>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="idDelete" id="idDelete">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">rời khỏi</button>
                    <button type="submit" class="btn btn-secondary" data-dismiss="modal">Lưu thay đổi</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
