<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setLocale value="${locale}" />
<!DOCTYPE html>
<html lang="es">
<head>
<title>Project explorer</title>
<meta charset="utf-8" />

<link rel="stylesheet" href="<c:url value="/css/main.css"/>"
	type="text/css" />

<!--[if IE]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

<!--[if lte IE 7]>
		<link rel="stylesheet" type="text/css" media="all" href="css/ie.css"/>
		<script src="js/IE8.js" type="text/javascript"></script><![endif]-->

<!--[if lt IE 7]>
		<link rel="stylesheet" type="text/css" media="all" href="css/ie6.css"/><![endif]-->

</head>

<body id="index" class="home">

	<header id="banner" class="body">
		<nav>
			<ul>
				<li><a href="<c:url value="/"/>"><strong>Project</strong></a></li>
				<li class="active"><a href="#">projetos</a></li>
				<li><a href="#">usuários</a></li>
				<li><a href="#">sobre</a></li>
			</ul>
		</nav>
	</header>
	<!-- /#banner -->
	<c:forEach var="error" items="${errors}">
    ${error.category} - ${error.message}<br>
	</c:forEach>