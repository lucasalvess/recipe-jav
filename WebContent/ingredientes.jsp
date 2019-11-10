<?php 
require_once('cabecalho.php'); 
require_once('../controller/ingredientesController.php');
require_once('../controller/retornaReceitaController.php');
require_once('../view/nav.php');
include('../help/erros.php');

$vazio = null;
$ic = new IngredientesController();
$rc = new retornaReceitaController();

$r = new Receita();
$r = $rc->retornaReceita($_GET['id']);

$ingredientes = $p->listarIngredientes($ic);

if($ingredientes == null){
	$_SESSION['info'] = 'Insira os ingredientes';
	$vazio = true;
	include('../help/erros.php');
}

?>
<div class="text-center">
	<div class="mt-2 mb-2">
		<img class="animated swing delay-2s" src="src/diet.svg" width="200em">
		<h1 class="lobster"><?=$r->getNome()?></h1>
	</div>
	<div class="text-left">
		<h1>Ingredientes:</h1>
	</div>
	<?php if (!$vazio): ?>
		<table class="table table-hover animated slideInUp">
			<thead class="thead-dark">
				<tr>
					<th scope="col" class="d-none d-md-table-cell">Nome</th>
					<th scope="col" class="d-none d-md-table-cell">Medida</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<?php  foreach ($ingredientes as $i) :?>
						<tr>
							<td><?=$r->getNome()?></td>
							<td><?=$r->getMedida()?></td>
							<td><a href="../controller/deleteIngredienteController.php?r=<?=$r->getId()?>"><button type="button" class="btn btn-danger">Excluir</button></td></a>
						</tr>			
					<?php endforeach ?>
				</tbody>
			</table>
		<?php endif; ?>
		<a class="btn btn-outline-success col-md-2 col-sm-4" href="prepara-receita.php">Nova Receita</a>		
	</div>
	<?php require_once('rodape.php') ?>					