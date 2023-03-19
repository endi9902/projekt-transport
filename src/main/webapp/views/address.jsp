<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 05.12.2022
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="label.titleAddress"/></title>
</head>
<body>
<h2><spring:message code="label.address"/></h2>
<form:form method="post" action="addAddress.html" modelAttribute="address">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="street"><spring:message code="label.street"/></form:label></td>
            <td><form:input path="street" /></td>
            <td><form:errors path="street"/></td>
        </tr>
        <tr>
            <td><form:label path="number"><spring:message code="label.number"/></form:label></td>
            <td><form:input path="number" /></td>
            <td><form:errors path="number"/></td>
        </tr>
        <tr>
            <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
            <td><form:input path="city" /></td>
            <td><form:errors path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="postalCode"><spring:message code="label.postalCode"/></form:label></td>
            <td><form:input path="postalCode" /></td>
            <td><form:errors path="postalCode"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${address.id==0}">
                    <input type="submit" value="<spring:message code="label.addAddress"/>"/>
                </c:if>
                <c:if test="${address.id!=0}">
                    <input type="submit" value="<spring:message code="label.editAddress"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<h3><spring:message code="label.addressList"/></h3>
<c:if  test="${!empty addressList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.street"/></th>
            <th><spring:message code="label.number"/></th>
            <th><spring:message code="label.city"/></th>
            <th><spring:message code="label.postalCode"/></th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${addressList}" var="address">
            <tr>
                <td>${address.street} </td>
                <td>${address.number} </td>
                <td>${address.city}</td>
                <td>${address.postalCode}</td>
                <td><a href="deleteAddress/${address.id}.html">delete</a></td>
                <td><a href="addresses.html?addressId=${address.id}">edit</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>