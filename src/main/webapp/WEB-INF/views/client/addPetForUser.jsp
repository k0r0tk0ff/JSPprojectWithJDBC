<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: k0r0tk0ff
  Date: 2/7/2017
  Time: 8:46 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MainMenu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css"></c:url>">
    <script src="<c:url value="/bootstrap/js/jquery.min.js"></c:url>"></script>
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"></c:url>"></script>
</head>
<body>

<h3>Add user`s <c:out value="${users.get(ownId).getLogin()}"></c:out> pet</h3>
</br>

<form action="${pageContext.servletContext.contextPath}/client/addpet.do" method="post">
    <input type="hidden" name="id" value="${ownId}">
    <div class="input-group">
        <span class="input-group-addon">Nick</span>
        <input id="nick" type="text" class="form-control" name="nick" placeholder="Enter nick of ${users.get(ownId).getLogin()} `s pet">
    </div>
    <div class="input-group">
        <span class="input-group-addon">Type</span>
        <input id="type" type="text" class="form-control" name="type" placeholder="Enter type (cat, dog, ...)">
    </div>
    <br/>
    <input type="submit" class="btn btn-info" value="Add pet">
</form>

<!-- Bootstrap table-->
<div class="container">
    <h2>Pet`s clinic customer</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>Pet`s Id</td>
            <td>Pet`s nick</td>
            <td>Pet`s type</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users.get(ownId).getUserPets()}" var="iterator">
            <tr>
                <td><c:out value="${iterator.getPetId()}"></c:out></td>
                <td><c:out value="${iterator.getNick()}"></c:out></td>
                <td><c:out value="${iterator.getType()}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
</div>
<br/>
</body>
</html>