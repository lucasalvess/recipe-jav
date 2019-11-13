<jsp:include page="cabecalho.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Monta logica de adicionar ingredientes -->
<script type="text/javascript" src="js/tail.active.js"></script>

<div class="mt-2 mb-2 text-center">
	<img class="animated bounce infinite" src="src/oven.svg" width="150em">
	<h1 class="lobster">Esquentando...</h1>
</div>

<form class="col-md-6 col-sm-12 offset-md-3 animated  fadeInLeft slow" method="POST" action="alteraReceita">
	<input type="hidden" name="id" value="${receita.id}">
	<div class="form-group">
		<label class="text-left" for="nome">Nome da receita</label>
		<input value="${receita.nome}" type="text" class="form-control" id="nome" placeholder="Minha receita" name="nome" required>
	</div>
	<div class="form-group">
		<label class="text-left" for="desc">Descriçao</label>
		<textarea class="form-control" id="descricao" name="descricao" required>${receita.descricao}</textarea>
	</div>

	<div class="form-group">
		<label class="text-left" for="preparo">Preparo</label>
		<textarea class="form-control" id="preparo" name="preparo" required>${receita.passos}</textarea>
	</div>
	<div class="row">
		<div class='form-group date col-6'>
			<label for="tempo">Tempo de preparo</label>		
			<input type='text' value="${receita.tempo}" class="form-control" name="tempo" id="tempo" required>
		</div>
		<div class="form-group col-6 mb-3">
			<div class="text-left">
				<label class="input-text" for="categ">Categoria</label>
			</div>
			<select class="custom-select" id="categ" name="categoria" value="${receita.categoria}">
				<option value="Outros" ${receita.categoria == "Outros"? "selected": ""}>Outros</option>
				<option value="Acompanhamentos" ${receita.categoria == "Acompanhamentos"? "selected":""} >Acompanhamentos</option>
				<option value="Aperitivos" ${receita.categoria == "Aperitivos"? "selected":""}>Aperitivos</option>
				<option value="Entradas" ${receita.categoria == "Entradas"? "selected":""}>Entradas</option>
				<option value="Lanches" ${receita.categoria == "Lanches"? "selected":""}>Lanches</option>
				<option value="Molhos"${receita.categoria == "Molhos"? "selected":""}>Molhos</option>
				<option value="Prato" ${receita.categoria == "Prato"? "selected":""}>Prato Principal</option>
				<option value="Saladas" ${receita.categoria == "Saladas"? "selected":""}>Saladas</option>
				<option value="Sobremesas" ${receita.categoria == "Sobremesa"? "selected":""}>Sobremesas</option>
			</select>
		</div>
	</div>
	<!-- Se os ingredientes foi estao na receita, seleciona -->
	<div class="form-group date">
		<label class="input-text" for="medida" >Ingredientes</label>
			<select id="ingredientes" name="ingredientes[]" class="form-control custom-select" multiple multiPinSelected="true" >
				
				<c:forEach var="ingrediente" items="${ingredientes}">

					<option value="${ingrediente.id}">${ingrediente.nome}</option>

				</c:forEach>
	
			</select>				
	</div>
		<div class="text-center">
			<button type="submit" class="btn btn-outline-info">Salvar Receita</button>
		</div>
	</div>
		</form> 

<jsp:include page="rodape.jsp"></jsp:include>