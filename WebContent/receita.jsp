<jsp:include page="cabecalho.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mt-2 mb-2 text-center ">
	<img class="animated bounce infinite" src="src/book.svg" width="150em">
	<h1 class="lobster">${receita.nome}</h1>
	<p class="text-muted"> Categoria: ${receita.categoria}</p>
	<p class="text-muted"> Preparo: ${receita.tempo}</p>
</div>
<div class="mt-5 col-md-6 col-sm-12 offset-md-3 animated  fadeInLeft slow">
	<h4>Descricao: </h4>
	<p>${receita.descricao}</p>
</div>
<div class="mt-5 col-md-6 col-sm-12 offset-md-3 animated delay-1s fadeInLeft slow">
	<h4>Passo a passo: </h4>
	<p>${receita.passos}</p>
</div>
<div class="mt-5 col-md-6 col-sm-12 offset-md-3 animated delay-2s fadeInLeft slow">
	<?php if ($ingredientes!= null):?>
	<h4>Ingredientes: </h4>
	<?php foreach ($ingredientes as $i) : ?>
		<p> - <?=$i->getNome()?></li>
		<?php endforeach; ?>
	<?php endif; ?>	
</div>

<div class="text-center">
	
	<button class="btn btn-outline-dark" onclick="goBack()">Voltar</button>
</div>

<!-- Monta logica de adicionar ingredientes -->
<script type="text/javascript" src="js/tail.active.js"></script>

<jsp:include page="rodape.jsp"></jsp:include>