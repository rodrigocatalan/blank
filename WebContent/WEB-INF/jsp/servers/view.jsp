<%@ include file="../header.jsp"%>
<section id="content" class="body">
	<ol id="posts-list" class="hfeed">
		<li>
			<article class="hentry">
				<header>
					<h2 class="entry-title">
						<a href="#" rel="bookmark" title="xxx">${server.name}</a>
					</h2>
				</header>

				<div class="entry-content">
					<p>${server.ip}</p>
					<p>${server.description}</p>
					<p>${server.operatingSystem.description}</p>
				</div>
				<!-- /.entry-content -->
			</article>
		</li>
	</ol>
	<!-- /#posts-list -->
</section>
<!-- /#content -->
<section id="content" class="body">

	<ol id="posts-list" class="hfeed">
		<li>
			<form action="<c:url value="/projects/${project.id}/servers"/>" 
				method="post" name="addProject">
				<fieldset>
					<label for="name">Nome:</label> 
					<input type="text" name="server.name" 
						placeholder="Preencha com o nome do servidor" />
					<label for="email">Descrição:</label>
					<input type="text" name="server.description" 
						placeholder="Preencha com a descrição do servidor" />
					<label for="ip">IP:</label>
					<input type="text" name="server.ip"
						 placeholder="Preencha com o ip do servidor" /> <br>
					<input type="submit" value="Save" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>

	</ol>
	<!-- /#posts-list -->

</section>
<%@ include file="../footer.jsp"%>