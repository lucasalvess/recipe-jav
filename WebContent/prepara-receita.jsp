<?php
require_once('cabecalho.php');
require_once('nav-sub.php');
require_once('../help/erros.php');
require_once('../controller/retornaReceitaController.php');

$rc = new RetornaReceitaController();

$ingredientes = $rc->ingredientes();

?>

<div class="mt-2 mb-2 text-center ">
	<img class="animated bounce infinite" src="src/cooking-pot.svg" width="150em">
	<h1 class="lobster">Cozinhando...</h1>
</div>

<form id="form_receita" class="col-md-6 col-sm-12 offset-md-3 animated  fadeInLeft slow" method="post" action="../controller/salvaReceitaController">
	<div class="form-group">
		<label class="text-left" for="nome">Nome da receita</label>
		<input type="text" class="form-control" id="nome" placeholder="Minha receita" name="nome" required>
	</div>
	<div class="form-group">
		<label class="text-left" for="desc">Descrição</label>
		<textarea class="form-control" id="desc" name="descricao" required></textarea>
	</div>

	<div class="form-group">
		<label class="text-left" for="preparo">Preparo</label>
		<textarea class="form-control" id="preparo" name="preparo" required></textarea>
	</div>
	<div class="row">
		<div class='form-group date col-6'>
			<label for="tempo">Tempo de preparo</label>		
			<input type='time' class="form-control" name="tempo" id="tempo" required/>
		</div>
		<div class="form-group col-6 mb-3">
			<div class="text-left">
				<label class="input-text" for="categ">Categoria</label>
			</div>
			<select class="custom-select" id="categ" name="categoria">
				<option selected>Outros</option>
				<option value="Acompanhamentos">Acompanhamentos</option>
				<option value="Aperitivos">Aperitivos</option>
				<option value="Entradas">Entradas</option>
				<option value="Lanches">Lanches</option>
				<option value="Molhos">Molhos</option>
				<option value="Prato">Prato Principal</option>
				<option value="Saladas">Saladas</option>
				<option value="Sobremesas">Sobremesas</option>
			</select>
		</div>
	</div>
	<div class="form-group date">
		<label class="input-text" for="medida" >Ingredientes</label>
		<select id="ingredientes" name="ingredientes[]" class="form-control custom-select" multiple >
			<?php foreach ($ingredientes as $i) : ?>

				<option value="<?=$i->getId()?>"><?=$i->getNome()?></option>

			<?php endforeach ?>
		</select>
	</div>


	<div class="text-center mt-5">
		<button type="submit" class="btn btn-outline-info">Salvar Receita</button>

	</div>
</form> 

<!-- Monta logica de adicionar ingredientes -->
<script type="text/javascript" src="js/tail.active.js"></script>

<?php require_once('rodape.php') ?>