<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 05.12.2022
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<div class="tab-content">
    <form class="form-signin" name='login' action="<c:url value='login' />" method='POST'>
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="text"  name='login' id="inputEmail"  class="form-control" placeholder="Login" required/>
            <label class="form-label" for="inputEmail" ><spring:message code="label.login"/></label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="password" name='password' id="inputPassword"  class="form-control" placeholder="Password" required/>
            <label class="form-label" for="inputPassword"><spring:message code="label.password"/></label>
        </div>
        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4" ><spring:message code="label.signin"/></button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <p><spring:message code="label.donthaveaccount"/><a href="/appUsers.html" class="link-info"><spring:message code="label.registration"/></a></p>

    </form>
</div>
