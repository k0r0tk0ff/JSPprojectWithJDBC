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
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css"></c:url>">
    <script src="<c:url value="/bootstrap/js/jquery.min.js"></c:url>"></script>
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"></c:url>"></script>
</head>
<body>
<div class="container">
    <%--<h3>Show pets of customer <c:out value="${users.get($ownId).getLogin()}"></c:out></h3>--%>
    <h3>Show pets of customer <c:out value="${users.get(param['id']).getLogin()}"></c:out></h3>
    <%--<h3>Show pets of customer <c:out value="${param['id']}"></c:out></h3>--%>
 </br>
</div>

<!-- Bootstrap table-->
<div class="container">
 <table class="table table-striped">
     <%--<h2> SessionID = <c:out value="${session.getId()}"></c:out></h2>--%>
     <thead>
     <tr>
         <td>Pet`s Id</td>
         <td>Pet`s nick</td>
         <td>Pet`s type</td>
     </tr>
     </thead>
     <tbody>
     <c:forEach items="${users.get(ownId).getUserPets()}" var="i">
         <tr>
             <td><c:out value="${i.getPetId()}"></c:out></td>
             <td><c:out value="${i.getNick()}"></c:out></td>
             <td><c:out value="${i.getType()}"></c:out></td>
             <td>
                 <%--<a href="/petdelete.do?id=${ownId}&petId=${i.getPetId()}">Delete pet</a>--%>
                <form action="/petdelete.do?id=${ownId}&petId=${i.getPetId()}" method="post">
                <input type="submit" class="btn btn-info" value="del Pet">
                </form>
             </td>
         </tr>
     </c:forEach>
     </tbody>
 </table>
 <br/>
</div>
<div class="container">
 <%--<a href='/login.do' class="btn btn-info" role="button">Main page</a>--%>
 <a href='/users/UsersView.do' class="btn btn-info" role="button">Main page</a>
<%--    <form action="/users/UsersView.do" method="post">
        <input type="submit" class="btn btn-info" value="Main page">
    </form>--%>
</div>
<br/>
</body>
</html>