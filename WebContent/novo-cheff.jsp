<?php 
require_once('cabecalho.php');
require_once('../help/erros.php');
?>
<div class="mt-5 animated  fadeInLeft slow">
	<div class="text-center ">
		<img class="animated delay-2s rubberBand" src="src/apron.svg" width="200em" >
		<h1 class="lobster">Cadastro</h1>
	</div>
	<form class="col-md-6 col-sm-12 offset-md-3" method="post" action="../controller/cadastroController.php">
		<div class="form-group ">
			<label for="usuario">Nome de usuario</label>
			<input type="text" class="form-control" id="usuario" name="usuario" aria-describedby="usuarioHelp" placeholder="Insira seu usuario" required>
		</div>
		<div class="form-group">
			<label for="email">Insira um email valido</label>
			<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="exemplo@email.com" required>
		</div>
		<div class="form-group">
			<label for="senha">Insira sua senha</label>
			<input type="password" class="form-control" id="senha" name="senha" placeholder="Minimo 8 caracteres" required minlength="8">
		</div>
		<div class="form-group">
			<label for="senha">Confirme sua senha</label>
			<input type="password" class="form-control" id="senha" name="senha2" placeholder="Minimo 8 caracteres" required minlength="8">
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-dark col-sm-4">Cadastrar</button>
		</div>
		<br>
		<a href="login.php">Já tem conta? então é só logar ;)</a>	
	</form>
	
</div>

<?php require_once('rodape.php') ?>
