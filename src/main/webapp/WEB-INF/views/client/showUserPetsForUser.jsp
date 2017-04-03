<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: k0r0tk0ff
  Date: 3/21/2017
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
                <form action="${pageContext.request.contextPath}/client/petdelete.do?id=${ownId}&petId=${i.getPetId()}" method="post">
                <input type="submit" class="btn btn-info" value="del Pet">
                </form>
             </td>
         </tr>
     </c:forEach>
     </tbody>
 </table>
 <br/>
</div>
<%--<div class="container">
    <a href="${pageContext.servletContext.contextPath}/users/addpet.do?id=${user.id}">AddPet</a>
</div>--%>
<%--
<form action="${pageContext.request.contextPath}/client/addpet.do?id=${ownId}" method="post">
    <input type="submit" class="btn btn-info" value="Add Pet">
</form>
--%>
<div class="container">
<a href="${pageContext.servletContext.contextPath}/client/addpet.do?id=${ownId}">AddPet</a>
</div>
<br/>
</body>
</html>