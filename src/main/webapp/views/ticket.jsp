<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 18.01.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy ticket page</title>
</head>
<body>
<form:form method="post" action="addTicket.html" modelAttribute="ticket">
    <table>
        <tr>
            <td><form:hidden path="id"/>
        </tr>
<%--        <tr>--%>
<%--            <td><form:label path="appUser.id"><spring:message code="label.appUserLoged"/></form:label></td>--%>
<%--            <td><form:input path="appUser.id" /></td>--%>
<%--            <td><form:errors path="appUser.id"/></td>--%>
<%--        </tr>--%>
        <tr>
            <td><form:label path="connection"><spring:message code="label.connection"/></form:label></td>
            <td><form:select path="connection">
                <c:forEach items="${connectionList}" var="connection">
                    <option value="${connection.id}" ${connection.id == selectedConnection ? 'selected="selected"' : ''}>${connection.startStation} ${connection.endStation} ${connection.date} ${connection.time} ${connection.price}</option>
                </c:forEach>
            </form:select></td>
            <td><form:errors path="connection"/></td>
        </tr>
<%--        <tr>--%>
<%--            <td><form:label path="appUser"><spring:message code="label.appUserLoged"/></form:label></td>--%>
<%--            <td><form:select path="appUser">--%>
<%--                <c:forEach items="${appUserList}" var="appUser">--%>
<%--                    <option value="${appUser.id}" ${appUser.id == selectedAppUser ? 'selected="selected"' : ''}>${appUser.login}</option>--%>
<%--            </c:forEach>--%>
<%--            </form:select></td>--%>
<%--            <td><form:errors path="appUser"/></td>--%>
<%--        </tr>--%>
    </table>
    <button type="submit" href= "/addTicket" class="btn btn-primary btn-block mb-4" >Kup bilet</button>
</form:form>
<h1><spring:message code="label.UsersTickets"/></h1>
<c:if  test="${!empty ticketList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstName"/></th>
            <th><spring:message code="label.lastName"/></th>
            <th><spring:message code="label.email"/></th>
            <th><spring:message code="label.telephone"/></th>
            <th><spring:message code="label.startStation"/></th>
            <th><spring:message code="label.endStation"/></th>
            <th><spring:message code="label.date"/></th>
            <th><spring:message code="label.time"/></th>
            <th><spring:message code="label.price"/></th>
        </tr>
        <c:forEach items="${ticketList}" var="ticket">
            <tr>
                <td>${ticket.appUser.firstName} </td>
                <td>${ticket.appUser.lastName} </td>
                <td>${ticket.appUser.email} </td>
                <td>${ticket.appUser.telephone} </td>
                <td>${ticket.connection.startStation} </td>
                <td>${ticket.connection.endStation} </td>
                <td>${ticket.connection.date}</td>
                <td>${ticket.connection.time}</td>
                <td>${ticket.connection.price}</td>
                <td><a href="/pay-${ticket.id}">Zapłać</a></td>
                <td><a href="generatePdf-${ticket.id}">PDF</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<%--    <button type="submit" href= "#" class="btn btn-primary btn-block mb-4" >Generuj PDF</button>--%>
<%--    <button type="submit" href= "#" class="btn btn-primary btn-block mb-4" >Zapłać</button>--%>
</body>
</html>