<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<!DOCTYPE html>
<html lang="es">
<head>
<title>Project explorer</title>
<meta charset="utf-8" />

<link rel="stylesheet" href="css/main.css" type="text/css" />

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
			</ul>
		</nav>
	</header>
	<!-- /#banner -->
<section id="content" class="body">

	<ol id="posts-list" class="hfeed">
		<li>
			<form action="<c:url value="/login"/>" method="post"
				name="addProject">
				<fieldset>
					<label for="name">Usuário:</label> 
					<input type="text" name="login"
						placeholder="Preencha com o nome de usuário" /> 
					<label for="email">Senha:</label>
					<input type="password" name="password"
						placeholder="Preencha com a senha" />
						<br> 
					<input type="submit" value="Login" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>

	</ol>
	<!-- /#posts-list -->

</section>
<!-- /#content -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<footer id="contentinfo" class="body">

		<p>
			2012-2012 <a href="http://ahrpius.com.br">ahrpius</a>.
		</p>
	</footer>
	<!-- /#contentinfo -->

</body>
