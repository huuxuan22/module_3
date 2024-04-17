<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 28/02/2024
  Time: 9:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <style>
    form {
      width: 400px;
    }
  </style>
</head>
<body>
<form action="/employee?action=addNewUser" method="post">
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Account</label>
    <input type="text" name="userName" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword2" class="form-label">Password</label>
    <input type="text" name="passWord"  class="form-control" id="exampleInputPassword2">
  </div>
  <button type="submit" class="btn btn-primary" >Tạo</button>
</form>
</body>
</html>
