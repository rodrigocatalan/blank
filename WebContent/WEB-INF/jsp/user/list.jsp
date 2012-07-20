<%@ include file="../header.jsp"%>
<c:forEach var="error" items="${errors}">
    ${error.category} - ${error.message}<br>
</c:forEach>
<c:forEach var="user" items="${users}">
	<section id="content" class="body">

		<ol id="posts-list" class="hfeed">
			<li>
				<article class="hentry">
					<header>
						<h2 class="entry-title">
							<a href="#" rel="bookmark" title="Permalink to this POST TITLE">${user.name}</a>
						</h2>
					</header>

					<footer class="post-info">
						<abbr class="published"><fmt:formatDate
								value="${user.creation.time}" /></abbr>

						<address class="vcard author">
							por <a class="url fn" href="<c:url value="/users/"/><c:out value="${user.owner.id}"/>">
								${user.owner.name}
							</a>
						</address>
					</footer>
					<!-- /.post-info -->

					<div class="entry-content">
						<p>${user.login}</p>
					</div>
					<!-- /.entry-content -->
				</article>
			</li>

		</ol>
		<!-- /#posts-list -->

	</section>
	<!-- /#content -->
</c:forEach>
<section id="content" class="body">

	<ol id="posts-list" class="hfeed">
		<li>
			<form action="<c:url value="/users"/>" method="post"
				name="addProject">
				<fieldset>
					<label for="name">Nome:</label> 
					<input type="text" name="user.name"
						placeholder="Preencha com o nome do usuário" /> 
					<label for="name">Login:</label> 
					<input type="text" name="user.login"
						placeholder="Preencha com o login do usuário" /> 
					<label for="name">Password:</label> 
					<input type="text" name="user.password"
						placeholder="Preencha com a nova senha do usuário" /> 
						<br> 
					<input type="submit" value="Save" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>

	</ol>
	<!-- /#posts-list -->

</section>
<!-- /#content -->

<%@ include file="../footer.jsp"%>