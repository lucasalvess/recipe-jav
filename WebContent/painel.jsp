<?php 
require_once('cabecalho.php'); 
require_once('../controller/painelController.php');
require_once('../view/nav.php');
include('../help/erros.php');

$vazio = null;
$p = new PainelController();
$u = unserialize($_SESSION['usuario']);
$receitas = $p->listarReceitas($u);


if($receitas == null){
	$_SESSION['info'] = 'Você ainda nao possui receitas';
	$vazio = true;
	include('../help/erros.php');
}

?>
<div class="text-center">
	<div class="mt-2 mb-2">
		<img class="animated swing delay-2s" src="src/recipe-book.svg" width="200em">
		<h1 class="lobster">Livro de receitas</h1>
	</div>
	<?php if (!$vazio): ?>
		<table class="table table-hover animated slideInUp">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Receita</th>
					<th scope="col" class="d-none d-md-table-cell">Descriçao</th>
					<th scope="col" class="d-none d-md-table-cell">Categoria</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<?php  foreach ($receitas as $r) :?>
						<tr onclick="acessaReceita(<?=$r->getId()?>)">
							<td><?=$r->getNome()?></td>
							<td class="d-none d-md-table-cell"><?=substr($r->getDescricao(),0,40)?></td>
							<td class="d-none d-md-table-cell"><?=$r->getCategoria()?></td>
							<td><a href="requenta-receita.php?r=<?=$r->getId()?>"><button type="button" class="btn btn-primary">Editar</button></td></a>
							<td><a href="../controller/deleteReceitaController.php?r=<?=$r->getId()?>"><button type="button" class="btn btn-danger">Excluir</button></td></a>
						</tr>			
					<?php endforeach ?>
				</tbody>
			</table>
		<?php endif; ?>
		<a href="prepara-receita.php">
			<button type="button" class="btn btn-outline-success col-md-2 col-sm-4 mb-5">Nova Receita</button>
		</a>
	</div>
	<?php require_once('rodape.php') ?>					