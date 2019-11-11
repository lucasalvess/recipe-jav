
<jsp:include page="cabecalho.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="text-center">
	<div class="mt-2 mb-2">
		<img class="animated swing delay-2s" src="src/recipe-book.svg" width="200em">
		<h1 class="lobster">Livro de receitas</h1>
	</div>
	<?php if (!$vazio):?>
		<table class="table table-hover animated slideInUp">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Receita</th>
					<th scope="col" class="d-none d-md-table-cell">Descrição</th>
					<th scope="col" class="d-none d-md-table-cell">Categoria</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="receita" items="${receitas}">
							
						<tr onclick="acessaReceita(${receita.id})">
							<td>${receita.nome}</td>
							<td class="d-none d-md-table-cell">${receita.descricao}</td>
							<td class="d-none d-md-table-cell">${receita.categoria}</td>
							<td><a href="alteraReceita?${receita.id}"><button type="button" class="btn btn-primary">Editar</button></td></a>
							<td><a href="excluiReceita?${receita.id}"><button type="button" class="btn btn-danger">Excluir</button></td></a>
						</tr>			
			</c:forEach>		
				</tbody>
			</table>
		<?php endif; ?>
		<a href="preparaReceita">
			<button type="button" class="btn btn-outline-success col-md-2 col-sm-4 mb-5">Nova Receita</button>
		</a>
	</div>
<jsp:include page="rodape.jsp"></jsp:include>				