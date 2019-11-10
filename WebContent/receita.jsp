<?php 
require_once('cabecalho.php');
require_once('nav-sub.php');
require_once('../controller/retornaReceitaController.php');
require_once('../model/Receita.php');

//Instancia controller
$c = new retornaReceitaController();

$r = $c->retornaReceita($_GET['r']);
$ingredientes = $c->retornaIngredientes($_GET['r']);

?>

<div class="mt-2 mb-2 text-center ">
	<img class="animated bounce infinite" src="src/book.svg" width="150em">
	<h1 class="lobster"><?=$r->getNome()?></h1>
	<p class="text-muted"> Categoria: <?=$r->getCategoria()?></p>
	<p class="text-muted"> Preparo: <?=strftime("%R", strtotime($r->getTempo()))?></p>
</div>
<div class="mt-5 col-md-6 col-sm-12 offset-md-3 animated  fadeInLeft slow">
	<h4>Descricao: </h4>
	<p><?=$r->getDescricao()?></p>
</div>
<div class="mt-5 col-md-6 col-sm-12 offset-md-3 animated delay-1s fadeInLeft slow">
	<h4>Passo a passo: </h4>
	<p><?=$r->getPassos()?></p>
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

<?php require_once('rodape.php'); ?>