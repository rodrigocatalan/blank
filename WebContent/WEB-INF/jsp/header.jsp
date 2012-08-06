<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Project explorer</title>
<meta charset="utf-8" />

<link rel="stylesheet" href="<c:url value="/css/main.css"/>" type="text/css" />

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
		<h1>
			<a href="#">Project explorer <strong>Projetos correntes</strong></a>
		</h1>
		<nav>
			<ul>
				<li><a href="<c:url value="/projects"/>">projetos</a></li>
				<li><a href="<c:url value="/users"/>">usuários</a></li>
				<li><a href="<c:url value="/operatingSystems"/>">O.S.'s</a></li>
				<li><a href="<c:url value="/about"/>">sobre</a></li>
			</ul>
		</nav>
	</header>
	<!-- /#banner -->
	<c:if test="${not empty errors}">
	<aside id="featured" class="body">
		<c:forEach var="error" items="${errors}">
		<hgroup>
			<h2>Erros:</h2>
		</hgroup>
		<article>
			<hgroup>
				<h1>${error.category}</h1>
			</hgroup>
			<p>${error.message}</p>
		</article>
		</c:forEach>		
	</aside>
	</c:if>
	<!-- /#featured -->	