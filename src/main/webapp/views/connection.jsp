<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 18.01.2023
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Adding Connection page</title>
</head>
<body>
<h1><spring:message code="label.connection"/></h1>
<form:form method="post" action="addConnection.html" modelAttribute="connection">
    <table>
        <tr>
            <td><form:hidden path="id"/>
        </tr>
        <tr>
            <td><form:label path="startStation"><spring:message code="label.startStation"/></form:label></td>
            <td><form:input path="startStation"/></td>
            <td><form:errors path="startStation"/></td>
        </tr>
        <tr>
            <td><form:label path="endStation"><spring:message code="label.endStation"/></form:label></td>
            <td><form:input path="endStation" /></td>
            <td><form:errors path="endStation"/></td>
        </tr>
        <tr>
            <td><form:label path="date"><spring:message code="label.date"/></form:label></td>
            <td><form:input path="date" /></td>
            <td><form:errors path="date"/></td>
        </tr>
        <tr>
            <td><form:label path="time"><spring:message code="label.time"/></form:label></td>
            <td><form:input path="time" /></td>
            <td><form:errors path="time"/></td>
        </tr>
        <tr>
            <td><form:label path="places"><spring:message code="label.places"/></form:label></td>
            <td><form:input path="places" /></td>
            <td><form:errors path="places"/></td>
        </tr>
        <tr>
            <td><form:label path="price"><spring:message code="label.price"/></form:label></td>
            <td><form:input path="price" /></td>
            <td><form:errors path="price"/></td>
        </tr>
    </table>
    <button type="submit" href= "/addConnection" class="btn btn-primary btn-block mb-4" ><spring:message code="label.addConn"/></button>

</form:form>
</body>
</html>