<%@ page import="java.util.List" %>
<%@ page import="model.EmployeeData.Position" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 28/02/2024
  Time: 12:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
      form{
        width: 300px;
        height: 500px;
        background-color: antiquewhite;
        border: 1px solid black;
      }
      .container {
        display: flex;
        justify-content: center; /* căn giữa theo chiều ngang */
        align-items: center; /* căn giữa theo chiều dọc */
        /* đặt chiều cao của container là 100% của viewport height */
      }

    </style>
</head>
<body>
<% String idUpdate = request.getParameter("e");   %>
<form class="container" method="post" action="/employee?action=update">
  <div class="content">
    <input type="hidden" name="id" value="<%=request.getParameter("idUpdate")%>">
    </br>
    Tên nhân Viên
    </br>
    <input type="text" name="name">
    </br>
    Ngày Sinh
    </br>
    <input type="text" name="birthday">
    </br>
    Chứng Minh nhân Dân
    </br>
    <input type="text" name="idCard">
    </br>
    Lương
    <br>
    <input type="text" name="salary">
    <br>
    Số Điện thoại
    <br>
    <input type="text" name="phone">
    <br>
    Email
    <br>
    <input type="text" name="email">
    <br>
    Địa chỉ
    <br>

    <input type="text" name="address">
    <br>
    Trình độ
  </br>
    <select name="educationId" id="e">
      <c:forEach var="education" items="${educationList}" >
        <option value="${education.id}" >${education.name}</option>
      </c:forEach>
    </select>
      </br>
    Vị Trí
    </br>
    <select name="positionId" id="p">
      <c:forEach var="position" items="${positionList}" >
        <option value="${position.id}" >${position.name}</option>
      </c:forEach>
    </select>
      </br>
    Bộ Phận:
    </br>
    <select name="divisionId" id="d">
      <c:forEach var="divition" items="${divisionList}" varStatus="status">
        <option value="${divition.id}" >${divition.name}</option>
      </c:forEach>
    </select>
    <button type="submit">SAVE</button>
  </div>
</form>
</body>
</html>
