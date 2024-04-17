<%@ page import="java.util.List" %>
<%@ page import="model.EmployeeData.User" %><%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 01/03/2024
  Time: 8:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <style>
    .form-container {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      border-radius: 10%;
      border: 1px groove;
    }
    .containers {
      position: relative;
      width: 100%;
      height: 100vh; /* Chiều cao của toàn bộ màn hình */
      display: flex;
      justify-content: center; /* Căn giữa theo chiều ngang */
      align-items: center; /* Căn giữa theo chiều dọc */
    }
  </style>
</head>
<body>
<%
//  List<User> userList = request.getParameter("userList");
%>
<div class="containers">
  <form action="/furama?action=checkUser" method="post" style="width: 400px;height: 400px" class="form-container">
    <div class="mb-3">
      <label class="form-label">Account</label>
      <input type="text" class="form-control" name="userName">
      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
      <label class="form-label">Password</label>
      <input type="password" class="form-control" name="passWord" >
    </div>
    <div class="mb-3 form-check">
      <input type="checkbox" class="form-check-input" name="password" id="exampleCheck1">
      <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</body>
</html>
