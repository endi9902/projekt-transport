<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 20.01.2023
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<body>
<form:form method="post" action="addTicket.html" modelAttribute="ticket">
    <table>
        <tr>
            <td><form:hidden path="id"/>
        </tr>
<%--        <tr>--%>
<%--            <td><form:label path="ticket.appUser.firstName"><spring:message code="label.firstName"/></form:label></td>--%>
<%--            <td><form:input path="ticket.appUser.firstName" /></td>--%>
<%--            <td><form:errors path="ticket.appUser.firstName"/></td>--%>
<%--        </tr>--%>
            <tr>
                <td><form:label path="ticket.connection.id"/></td>
                <td><form:input path="ticket.connection.id" class="form-control-plaintext" value="${connection.id}" readonly="true"/></td>
            </tr>
            <tr>
                <td><form:label path="ticket.appUser.login"/></td>
                <td><form:input path="ticket.appUser.login" readonly="true" class="form-control-plaintext" value="${pageContext.request.userPrincipal.name}"/></td>
            </tr>
<%--            <tr>--%>
<%--                <td><form:label path="connection.startStation"/></td>--%>
<%--                <td><form:input path="connection.startStation" readonly="true" class="form-control-plaintext" value="${connection.startStation}"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><form:label path="ticket.connection.endStation"/></td>--%>
<%--                <td><form:input path="ticket.connection.endStation" readonly="true" class="form-control-plaintext" value="${connection.endStation}"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><form:label path="ticket.connection.date"/></td>--%>
<%--                <td><form:input path="ticket.connection.date" readonly="true" class="form-control-plaintext" value="${connection.date}"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><form:label path="ticket.connection.time"/></td>--%>
<%--                <td><form:input path="ticket.connection.time" readonly="true" class="form-control-plaintext" value="${connection.time}"/></td>--%>
<%--            </tr>--%>
        </form:form>

    </table>
    <button type="submit" href= "/addTicket" class="btn btn-primary btn-block mb-4" >Kup bilet</button>
</body>
</html>
