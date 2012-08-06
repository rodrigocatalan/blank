<%@ include file="../header.jsp"%>

<c:forEach var="project" items="${projects}">
	<section id="content" class="body">

		<ol id="posts-list" class="hfeed">
			<li>
				<article class="hentry">
					<header>
						<h2 class="entry-title">
							<a href="<c:url value="/projects/"/><c:out value="${project.id}"/>"
								rel="bookmark" title=""> ${project.name} </a>
						</h2>
						
					</header>

					<footer class="post-info">
						<abbr class="published"><fmt:formatDate
								value="${project.creation.time}" /></abbr>

						<address class="vcard author">
							por <a class="url fn"
								href="<c:url value="/users/"/><c:out value="${project.owner.id}"/>">
								${project.owner.name} </a>
						</address>
					</footer>
					<!-- /.post-info -->

					<div class="entry-content">
						<p>${project.description}</p>
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
			<form action="<c:url value="/projects"/>" method="post"
				name="addProject">
				<fieldset>
					<label for="name">Nome:</label> <input type="text" size="50"
						name="project.name" placeholder="Preencha com o nome do projeto" />
					<label for="email">Descrição:</label> <input type="text" size="50"
						name="project.description"
						placeholder="Preencha com a descrição do projeto" /> <br> <input
						type="submit" value="Save" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>

	</ol>
	<!-- /#posts-list -->

</section>
<!-- /#content -->

<%@ include file="../footer.jsp"%>