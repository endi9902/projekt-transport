<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 05.12.2022
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>AppUserRole</title>
</head>
<body>
<form:form method="post" action="addAppUserRole.html" modelAttribute="appUserRole">
    <table>
        <tr>
            <td><form:hidden path="id"/>
        </tr>
        <tr>
            <td><form:label path="role"><spring:message code="label.role"/></form:label></td>
            <td><form:input path="role" /></td>
            <td><form:errors path="role"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.addAppUserRole"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>