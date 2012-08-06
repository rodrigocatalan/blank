<%@ include file="../header.jsp"%>

<section id="content" class="body">
<a href="<c:url value="/projects"/>">Projetos</a> &gt;
<a href="<c:url value="/projects/"/><c:out value="${project.id}"/>"
	rel="bookmark"> ${project.name} 
</a>
</section>

<c:forEach var="server" items="${project.servers}">
<section id="content" class="body">
	Servidor:
	<ol id="posts-list" class="hfeed">
		<li>
			<article class="hentry">
				<header>
					<h2 class="entry-title">
						<a href="#" rel="bookmark" title="xxx"><c:out value="${server.name}"/></a>
					</h2>
				</header>

				<div class="entry-content">
					<p>${server.ip}</p>
					<p>${server.description}</p>
					<p>${server.operatingSystem.description}</p>
				</div>
				xxxxx, asdfasd,as dfasdf asdfa
				<div class="entry-content">
					<p>teste</p>
					<p>teste2</p>
					<p>software</p>
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
			<form action="<c:url value="/projects/${project.id}/servers"/>" 
				method="post" name="addServer">
				<fieldset>
					<label for="server.name">Nome:</label> 
					<input type="text" name="server.name" size="50"
						placeholder="Preencha com o nome do servidor" />
					<label for="server.description">Descrição:</label>
					<input type="text" name="server.description" size="50"
						placeholder="Preencha com a descrição do servidor" />
					<label for="server.ip">IP:</label>
					<input type="text" name="server.ip" size="50"
						 placeholder="Preencha com o ip do servidor" />
					<label for="server.operatingSystem.id">Sistema:</label>
					<select name="server.operatingSystem.id">
					<c:forEach items="${oss}" var="os">
						<option value="${os.id}"><c:out value="${os.description}"/></option>
					</c:forEach>
					</select>

					<input type="submit" value="Save" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>

	</ol>
	<!-- /#posts-list -->

</section>
<%@ include file="../footer.jsp"%>