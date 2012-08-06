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
			<form action="<c:url value="/servers/${server.id}/systemUsers"/>" 
				method="post" name="addSystemUser">
				<fieldset>
					<label for="systemUser.user">Usuário:</label> 
					<input type="text" name="systemUser.user" 
						placeholder="Preencha com o usuário" />
					<label for="systemUser.password">Senha:</label>
					<input type="text" name="systemUser.password" 
						placeholder="Preencha com a senha do usuário" />
					<label for="systemUser.description">Descrição:</label>
					<input type="text" name="systemUser.descriptio"
						 placeholder="Preencha detalhes sobre o usuário" /> <br>
					<input type="submit" value="Adicionar usuário" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>
		<li>
			<form action="<c:url value="/servers/${server.id}/installedSoftwares"/>" 
				method="post" name="addInstalledSoftware">
				<fieldset>
					<label for="systemUser.user">Usuário:</label> 
					<input type="text" name="systemUser.user" 
						placeholder="Preencha com o usuário" />
					<label for="systemUser.password">Senha:</label>
					<input type="text" name="systemUser.password" 
						placeholder="Preencha com a senha do usuário" />
					<label for="systemUser.description">Descrição:</label>
					<input type="text" name="systemUser.descriptio"
						 placeholder="Preencha detalhes sobre o usuário" /> <br>
					<input type="submit" value="Adicionar software" />
				</fieldset>
			</form> <!-- /.post-info -->
		</li>
	</ol>
	<!-- /#posts-list -->

</section>
<%@ include file="../footer.jsp"%>