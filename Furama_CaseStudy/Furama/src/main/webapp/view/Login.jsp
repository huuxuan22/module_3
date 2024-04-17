<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 27/02/2024
  Time: 2:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<style>
  * {
    box-sizing: border-box;
  }
  .col-1 {width: 8.33%;}
  .col-2 {width: 16.66%;}
  .col-3 {width: 25%;}
  .col-4 {width: 33.33%;}
  .col-5 {width: 41.66%;}
  .col-6 {width: 50%;}
  .col-7 {width: 58.33%;}
  .col-8 {width: 66.66%;}
  .col-9 {width: 75%;}
  .col-10 {width: 83.33%;}
  .col-11 {width: 91.66%;}
  .col-12 {width: 100%;}

  /*Phần header*/
  #Header{
    height: 100px;
    border: 1px solid black;
  }
  .col-2{
    border: 1px solid black;
    display: flex; /* Sử dụng display: flex để căn giữa các phần tử con */
    justify-content: center; /* Để căn giữa theo chiều ngang */
    align-items: center; /* Để căn giữa theo chiều dọc */
    border: 1px solid #ccc; /* Đường viền để nhìn rõ */
  }
  .col-8{
    border: 1px solid black;
  }
  .logo-container{
    border: 3px solid black;
    width: 64px;
    height: 64px;
    border-radius: 20%;

  }
  .logo {
    text-align: center; /* Để căn giữa nội dung bên trong */

  }
  a:hover{
    color: lightskyblue;
  }
  /*Phần Navbar*/
  #Navbar{
    background: #f0f0f0;

  }
  .menu {
    list-style-type: none;
  }
  li a {
    text-decoration: none;
    padding: 30px;
    font-size: 20px;
    color: black;
  }
  li {
    list-style-type: none;
    display: inline;
  }
  .col-8{
    display: flex;
    justify-content: center;
    line-height:60px;
  }
  .col-4 {
    display: flex;
    justify-content: center;
    position: relative;
    border: 1px solid black;
  }
  search{
    position: relative;
  }
  .form-control{
    border-radius: 30px;
    width: 300px;
    position: absolute;
    top: 50%;
    left: 50%; /* Di chuyển sang trái 50% của phần tử cha */
    transform: translate(-50%, -50%);
    padding-left: 30px;
  }
  .icon{
    position: absolute;
    /* Độ lệch sang trái của biểu tượng */
    width: 2px;
    height: 2px;
    right: 10px;
    top: 50%;
    transform: translateY(-50%); /* Để căn giữa theo chiều dọc */
  }


  /*Phần Content*/
  #Content {
    height: 500px;
    background-color: rgb(228, 228, 228);
  }
  .col-9 {
    border: 1px solid black;
  }
  .col-3 {
    border: 1px solid black;
  }

  /*Phần Footer*/
  #footer {
    height: 100px;
    background: gray;
    border: 1px solid black;
  }

</style>
</head>
<body>

<div id="Header" class="row">
  <div class="col-2">
    <div class="logo">
      <div class="logo-container">
        <img src="" alt="">
      </div>
      <div>FURAMA</div>
    </div>
  </div>
  <div class="col-8"></div>
  <div class="col-2">
    <form action="" method="get">
      <input type="hidden" name="action" value="FormLogin">
      <input type="submit" role="button" class="btn btn-primary" value="LOGIN">
    </form>
  </div>
</div>


<div id="Navbar" class="row">
  <div class="col-8">
    <div class="menu">
      <ul>
        <li><a href="">Home</a></li>
        <li><a href="">Employee</a></li>
        <li><a href="">Customer</a></li>
        <li><a href="">Service</a></li>
        <li><a href="">Contact</a></li>
      </ul>
    </div>
  </div>
  <div class="col-4">
    <div class="search">
      <form role="search">
        <input type="text" class="form-control" placeholder="Search" >
        <i class="fa fa-search icon"></i>
      </form>
    </div>
  </div>


</div>
<div id="Content" class="row">
  <div class="col-3">

  </div>
  <div class="col-9"></div>
</div>
<div id="Footer"></div>
</body>
</html>
