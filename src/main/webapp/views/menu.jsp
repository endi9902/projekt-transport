<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 11.11.2022
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/appUsers.html"><spring:message code="label.title"/></a>
    <br/>
    <a href="/appUserRole.html"><spring:message code="label.role"/></a>
    <br/>
    <a href="/adminPanel.html"><spring:message code="label.adminPanel"/></a>
    <br/>
    <a href="/connections.html"><spring:message code="label.connection"/></a>
    <br/>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
    <a href="/tickets.html"><spring:message code="label.tickets"/></a>
    <br/>
    <a href="/findConnection.html"><spring:message code="label.findConnection"/></a>
    <br/>
</sec:authorize>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<!-- csrf for log out-->
<form action="/logout" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<br/>
<div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <p>
            <spring:message code="label.welcome"/> : ${pageContext.request.userPrincipal.name} |
            <a href="javascript:formSubmit()"> Logout</a>
        </p>
    </c:if>
</div>