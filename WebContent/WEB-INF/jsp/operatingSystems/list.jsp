<%@ include file="../header.jsp"%>
<c:forEach var="os" items="${operatingSystemList}">
	<section id="content" class="body">

		<ol id="posts-list" class="hfeed">
			<li>
				<article class="hentry">
					<header>
						<h2 class="entry-title">
							<a href="<c:url value="/operatingSystems/"/><c:out value="${os.id}"/>"
								rel="bookmark" title=""> ${os.description} </a>
						</h2>
					</header>

					<footer class="post-info">
						<abbr class="published"><fmt:formatDate
								value="${os.creation.time}" /></abbr>

						<address class="vcard author">
							por <a class="url fn"
								href="<c:url value="/users/"/><c:out value="${os.owner.id}"/>">
								${os.owner.name} </a>
						</address>
					</footer>
					<!-- /.post-info -->

					<div class="entry-content">
						<p>${os.version}</p>
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
			<form action="<c:url value="/operatingSystems"/>" method="post"
				name="addOperatingSystem">
				<fieldset>
					<label for="operatingSystem.description">Descrição:</label> 
					<input type="text" name="operatingSystem.description" 
						placeholder="Preencha com o nome do S.O." />
					<label for="operatingSystem.version">Versão:</label> 
					<input type="text"
						name="operatingSystem.version"
						placeholder="Preencha com a versão do S.O." /> <br> <input
						type="submit" value="Save" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>

	</ol>
	<!-- /#posts-list -->

</section>
<!-- /#content -->

<%@ include file="../footer.jsp"%>