<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MainMenu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css"></c:url>">
    <script src="<c:url value="/bootstrap/js/jquery.min.js"></c:url>"></script>
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"></c:url>"></script>
</head>
<body>
    <div class="container">
        <h3>Add user</h3>
        <form action="${pageContext.servletContext.contextPath}/" method="post">
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
            <br/>
            <input type="submit" class="btn btn-info" value="add User">
        </form>
    </div>
    <br/>
</body>
</html>


