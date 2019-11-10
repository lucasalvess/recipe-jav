<?php
require_once('cabecalho.php');
require_once('nav-sub.php');
require_once('../controller/retornaReceitaController.php');
require_once('../model/Receita.php');

$r = new Receita();

$rc = new RetornaReceitaController();
$r = $rc->retornaReceita($_GET['r']);

$ingredientes = $rc->ingredientes();
$ingredienteDaReceita = $rc->retornaIngredientes($r->getId());

?>
<!-- Monta logica de adicionar ingredientes -->
<script type="text/javascript" src="js/tail.active.js"></script>

<div class="mt-2 mb-2 text-center">
	<img class="animated bounce infinite" src="src/oven.svg" width="150em">
	<h1 class="lobster">Esquentando...</h1>
</div>

<form class="col-md-6 col-sm-12 offset-md-3 animated  fadeInLeft slow" method="post" action="../controller/salvaReceitaController">
	<input type="hidden" name="id" value="<?=$r->getId()?>">
	<div class="form-group">
		<label class="text-left" for="nome">Nome da receita</label>
		<input value="<?=$r->getNome()?>" type="text" class="form-control" id="nome" placeholder="Minha receita" name="nome" required>
	</div>
	<div class="form-group">
		<label class="text-left" for="desc">Descrição</label>
		<textarea class="form-control" id="desc" name="descricao" required><?=$r->getDescricao()?></textarea>
	</div>

	<div class="form-group">
		<label class="text-left" for="preparo">Preparo</label>
		<textarea class="form-control" id="preparo" name="preparo" required><?=$r->getPassos()?></textarea>
	</div>
	<div class="row">
		<div class='form-group date col-6'>
			<label for="tempo">Tempo de preparo</label>		
			<input type='time' value="<?=$r->getTempo()?>" class="form-control" name="tempo" id="tempo" required>
		</div>
		<div class="form-group col-6 mb-3">
			<div class="text-left">
				<label class="input-text" for="categ">Categoria</label>
			</div>
			<select class="custom-select" id="categ" name="categoria" value="">
				<option value="Outros" <?=$r->getCategoria()=='Outros'?'selected':'';?>>Outros</option>
				<option value="Acompanhamentos" <?=$r->getCategoria()=='Acompanhamentos'?'selected':'';?>>Acompanhamentos</option>
				<option value="Aperitivos" <?=$r->getCategoria()=='Aperitivos'?'selected':'';?>>Aperitivos</option>
				<option value="Entradas" <?=$r->getCategoria()=='Entradas'?'selected':'';?>>Entradas</option>
				<option value="Lanches" <?=$r->getCategoria()=='Lanches'?'selected':'';?>>Lanches</option>
				<option value="Molhos"<?=$r->getCategoria()=='Molhos'?'selected':'';?>>Molhos</option>
				<option value="Prato" <?=$r->getCategoria()==='Prato'?'selected':'';?>>Prato Principal</option>
				<option value="Saladas" <?=$r->getCategoria()=='Saladas'?'selected':'';?>>Saladas</option>
				<option value="Sobremesas"<?=$r->getCategoria()=='Sobremesas'?'selected':'';?>>Sobremesas</option>
			</select>
		</div>
	</div>
	<!-- Se os ingredientes foi estao na receita, seleciona -->
	<div class="form-group date">
		<label class="input-text" for="medida" >Ingredientes</label>
		<?php if(isset($ingredienteDaReceita)): ?>
			<select id="ingredientes" name="ingredientes[]" class="form-control custom-select" multiple multiPinSelected="true" >
				<?php foreach ($ingredienteDaReceita as $ir):
					foreach ($ingredientes as $i) : ?>

						<option value="<?=$i->getId()?>" <?=$i->getNome()==$ir->getNome()?'selected':'';?>><?=$i->getNome()?></option>
					<?php endforeach; ?>
				<?php endforeach;?> 
				<?php else:?>
					<select id="ingredientes" name="ingredientes[]" class="form-control custom-select" multiple multiPinSelected="true">
						<?php foreach ($ingredientes as $i) : ?>

							<option value="<?=$i->getId()?>"><?=$i->getNome()?></option>

						<?php endforeach ?>

					<?php endif; ?>

				</select>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-outline-info">Salvar Receita</button>
			</div>

		</form> 

		<?php require_once('rodape.php') ?>