<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 11.11.2022
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<html>
<head>
    <title>App user page</title>
    <!-- Captcha Google -->
    <script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<h1><spring:message code="label.registration"/></h1>
<form:form method="post" action="addAppUser.html" modelAttribute="appUser">
    <table>
        <tr>
            <td><form:hidden path="id"/>
        </tr>
        <tr>
            <td><form:label path="login"><spring:message code="label.login"/></form:label></td>
            <td><form:input path="login"/></td>
            <td><form:errors path="login"/></td>
        </tr>
        <tr>
            <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
            <td><form:input type="password" path="password" /></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="firstName"><spring:message code="label.firstName"/></form:label></td>
            <td><form:input path="firstName" /></td>
            <td><form:errors path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName"><spring:message code="label.lastName"/></form:label></td>
            <td><form:input path="lastName" /></td>
            <td><form:errors path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
            <td><form:input path="email" /></td>
            <td><form:errors path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
            <td><form:input path="telephone" /></td>
            <td><form:errors path="telephone"/></td>
        </tr>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <tr>
            <td><form:label path="enabled"><spring:message code="label.enabled"/></form:label></td>
            <td><form:checkbox path="enabled" /></td>
            <td><form:errors path="enabled"/></td>
        </tr>
        </sec:authorize>
        <tr>
            <td><form:label path="address.street"><spring:message code="label.street"/></form:label></td>
            <td><form:input path="address.street" /></td>
            <td><form:errors path="address.street"/></td>
        </tr>
        <tr>
            <td><form:label path="address.number"><spring:message code="label.number"/></form:label></td>
            <td><form:input path="address.number" /></td>
            <td><form:errors path="address.number"/></td>
        </tr>
        <tr>
            <td><form:label path="address.city"><spring:message code="label.city"/></form:label></td>
            <td><form:input path="address.city" /></td>
            <td><form:errors path="address.city"/></td>
        </tr>
        <tr>
            <td><form:label path="address.postalCode"><spring:message code="label.postalCode"/></form:label></td>
            <td><form:input path="address.postalCode" /></td>
            <td><form:errors path="address.postalCode"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <div class="g-recaptcha" data-sitekey="6Le5bqEUAAAAACq42aKoz1eJXYbSlIDXmYmfkXzI"></div>
            </td>
        </tr>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <tr>
            <td><form:label path="appUserRole"><spring:message code="label.role"/></form:label></td>
            <td><form:select path="appUserRole" multiple="true">
                <form:options items="${appUserRoleList}" itemValue="id" itemLabel="role"/>
            </form:select></td>
            <td><form:errors path="appUserRole"/></td>
        </tr>
        </sec:authorize>
    </table>
    <button type="submit" href= "/addAppUser" class="btn btn-primary btn-block mb-4" >Zarejestruj sie</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form:form>
</body>
</html>