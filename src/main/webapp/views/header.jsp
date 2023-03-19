<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>

<div class="header">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="../../favicon.ico">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="<c:url value="/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"/>"></script>
		<!-- Bootstrap core CSS -->
		<link href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>" rel="stylesheet">
		<!-- Custom styles for this template -->
		<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
	</head>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#">Bilety PKP</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="/">Strona glowna</a>
				</li>
				<span style="float: right">
    				<a style="background-color: white" href="?lang=pl">pl</a> | <a style="background-color: white" href="?lang=en">en</a>
				</span>
				<br>
<%--				<form id="langForm" action="" method="get">--%>
<%--				<span style="float: right">--%>
<%--					<select size="1" name="lang" onchange="form.submit()">--%>
<%--	        			<option value ="pl">PL</option>--%>
<%--						<option value ="en">EN</option>--%>
<%--        			</select>--%>
<%--				</span>--%>
<%--				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
<%--					<a class="dropdown-item" href="?lang=pl">PL</a>--%>
<%--					<a class="dropdown-item" href="?lang=en">EN</a>--%>
<%--				</div>--%>
<%--				</form>--%>
			</ul>
		</div>
	</nav>
		<!-- Background image -->
<%--		<div--%>
<%--				class="p-10 text-center bg-image"--%>
<%--				style="--%>
<%--      background-image: url('../resources/images/tlo.jpg');--%>
<%--      height: 100px;--%>
<%--    ">--%>
<%--			<div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">--%>
<%--				<div class="d-flex justify-content-center align-items-center h-100">--%>
<%--&lt;%&ndash;					<div class="text-white">&ndash;%&gt;--%>
<%--&lt;%&ndash;						<h1 class="mb-3">Kup bilety na pociąg</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;					</div>&ndash;%&gt;--%>
<%--				</div>--%>
<%--			</div>--%>
<%--		</div>--%>
		<!-- Background image -->
</div>