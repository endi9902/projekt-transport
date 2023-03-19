<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 19.01.2023
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find Connection page</title>
</head>
<body>
<%--<h1><spring:message code="label.connection"/></h1>--%>
<%--<form:form method="post" action="connections.html" modelAttribute="connection">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td><form:hidden path="id"/>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="startStation"><spring:message code="label.startStation"/></form:label></td>--%>
<%--            <td><form:input path="startStation"/></td>--%>
<%--            <td><form:errors path="startStation"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="endStation"><spring:message code="label.endStation"/></form:label></td>--%>
<%--            <td><form:input path="endStation" /></td>--%>
<%--            <td><form:errors path="endStation"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:label path="date"><spring:message code="label.date"/></form:label></td>--%>
<%--            <td><form:input path="date" /></td>--%>
<%--            <td><form:errors path="date"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
    <c:if  test="${!empty connectionList}">
        <table class="data">
            <tr>
                <th><spring:message code="label.startStation"/></th>
                <th><spring:message code="label.endStation"/></th>
                <th><spring:message code="label.date"/></th>
                <th><spring:message code="label.time"/></th>
                <th><spring:message code="label.price"/></th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${connectionList}" var="connection">
                <tr>
                    <td>${connection.startStation} </td>
                    <td>${connection.endStation} </td>
                    <td>${connection.date}</td>
                    <td>${connection.time}</td>
                    <td>${connection.price}</td>
                </tr>
<%--                <td><a href="/addingTicket?connectionId=${connection.id}">Kup bilet</a></td>--%>
<%--                <td><a href="/addTicket">Kup bilet</a></td>--%>

<%--                <td><a href="/tickets.html"><spring:message code="label.goBuyTicket"/></a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </c:if>

<%--    <button type="submit" href= "#" class="btn btn-primary btn-block mb-4" >Kup bilet</button>--%>

</body>
</html>