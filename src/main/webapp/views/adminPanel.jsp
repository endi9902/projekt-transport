<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 15.01.2023
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
<h3><spring:message code="label.userList"/></h3>
<c:if  test="${!empty appUserList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstName"/></th>
            <th><spring:message code="label.lastName"/></th>
            <th><spring:message code="label.email"/></th>
            <th><spring:message code="label.telephone"/></th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${appUserList}" var="appUser">
            <tr>
                <td>${appUser.firstName} </td>
                <td>${appUser.lastName} </td>
                <td>${appUser.email}</td>
                <td>${appUser.telephone}</td>
                <td><a href="delete/${appUser.id}.html">delete</a></td>
                <td><a href="appUsers.html?appUserId=${appUser.id}">edit</a></td>
<%--                <td><a href="generatePdf-${appUser.id}">pdf</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>

