<%@page import="br.com.dasa.recipe.model.Usuario"%>



<div class="pos-f-t">
  <div class="collapse" id="navbarToggleExternalContent">
    <div class="bg-warning p-4">
      <h5 class="text-white h4">${usuario.nome}</h5>
      <span class="text-muted">${usuario.email}</span>
    </div>
  </div>
  <nav class="navbar navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a href="logout">
    <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Sair</button>
  </a>
  </nav>
</div>