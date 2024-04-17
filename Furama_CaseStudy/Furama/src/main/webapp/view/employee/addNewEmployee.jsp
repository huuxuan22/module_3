    <%--
      Created by IntelliJ IDEA.
      User: XUAN
      Date: 28/02/2024
      Time: 3:43 CH
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <form class="container" method="post" action="/employee?action=save">
        <div class="content">
            <input type="text" name="userName" value="<%=request.getParameter("userName")%>">
            </br>
            <input type="text" value="${idMax}" name="id">
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
            <select name="education" >
                <c:forEach var="education" items="${educationList}">
                    <option value="${education.getId()}">${education.getName()}</option>
                </c:forEach>
            </select>

            </br>
            Vị Trí
            <select name="position">
                <c:forEach var="position" items="${positionList}" >
                    <option value="${position.id}" name="">${position.name}</option>
                </c:forEach>
            </select>
            </br>
            Bộ Phận:
            <select name="division" >
                <c:forEach var="divition" items="${divisionList}" varStatus="status">
                    <option value="${divition.id}">${divition.name}</option>
                </c:forEach>
            </select>
            <button type="submit">SAVE</button>
        </div>
    </form>
    </body>
    </html>
