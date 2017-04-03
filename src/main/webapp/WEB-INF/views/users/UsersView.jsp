<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
    <div class="container">
        <h3>Add user</h3>
       <%-- <form action="${pageContext.servletContext.contextPath}/" method="post">  --%>
        <form action="${pageContext.servletContext.contextPath}/users/UsersView.do" method="post">
            <div class="input-group">
                <span class="input-group-addon">Login</span>
                <input id="login" type="text" class="form-control" name="login" placeholder="Login">
            </div>
            <div class="input-group">
                <span class="input-group-addon">Email</span>
                <input id="email" type="email" class="form-control" name="email" placeholder="Email">
            </div>
            <div class="input-group">
                <span class="input-group-addon">Password</span>
                <input id="password" type="password" class="form-control" name="password" placeholder="password">
            </div>
            <div class="form-group">
                <label for="role">Select role:</label>
                <%--<select class="form-control" id="role" name="role" type="text">--%>
                <select class="form-control" id="role" name="role">
                    <option>ROLE_ADMIN</option>
                    <option>ROLE_USER</option>
                </select>
            </div>
            <br/>
            <input type="submit" class="btn btn-info" value="add User">
        </form>
    </div>
    <br/>

    <!-- Bootstrap table-->
    <div class="container">
        <h2>Pet`s clinic customer</h2>
        <%--<h2> SessionID = <c:out value="${session.getId()}"></c:out></h2>--%>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>login</th>
                <th>email</th>
                <th>id</th>
                <th>role</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${users}" var="user">
             <tr>
                  <td><c:out value="${user.login}"></c:out></td>
                  <td><c:out value="${user.email}"></c:out></td>
                  <td><c:out value="${user.id}"></c:out></td>
                  <td><c:out value="${user.role}"></c:out></td>
                  <td><a href="${pageContext.servletContext.contextPath}/users/showpets.do?id=${user.id}">Show Pets</a></td>
                  <td><a href="${pageContext.servletContext.contextPath}/users/addpet.do?id=${user.id}">AddPet</a></td>
                  <td><a href="${pageContext.servletContext.contextPath}/users/edit.do?id=${user.id}">Edit user</a></td>
                  <td><a href="${pageContext.servletContext.contextPath}/users/del.do?id=${user.id}">Delete user</a></td>
             </tr>
             </c:forEach>
             </tbody>
        </table>
        <br/>
    </div>
    <br/>

    <!-- Simlple table-->
<%--    <table style="border: 1px solid black;" cellpadding="1" border="1">
            <tr>
                <th>login</th>
                <th>email</th>
                <th>id</th>
            </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.login}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.id}"></c:out></td>
            </tr>
        </c:forEach>
    </table>--%>
</body>
</html>


