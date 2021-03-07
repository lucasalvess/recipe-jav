package br.com.recipe.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.model.Ingrediente;
import br.com.recipe.model.Receita;
import br.com.recipe.model.Usuario;
import br.com.recipe.service.ReceitaService;

public class SalvaReceitaController extends HttpServlet{

	private final ReceitaService receitaService;
	private final IngredienteDAO ingredientesDAO;

	public SalvaReceitaController(ReceitaService receitaService, IngredienteDAO ingredientesDAO) {
		this.receitaService = receitaService;
		this.ingredientesDAO = ingredientesDAO;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		Receita receita = new Receita();
		
		receita.setNome(req.getParameter("nome"));
		receita.setDescricao(req.getParameter("descricao"));
		receita.setCategoria(req.getParameter("categoria"));
		receita.setPassos(req.getParameter("preparo"));
		receita.setTempo(req.getParameter("tempo"));

		try {
			//Grava receitas
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			//Grava ingredientes
			List<String> ingredientesSelecionados = Arrays.asList(req.getParameterValues("ingredientes"));
			List<Ingrediente> ingredientes = new ArrayList<>();

			ingredientesSelecionados.forEach(
					ingrediente -> ingredientes.add(new Ingrediente(1, ingrediente))
			);

			receita.setIngredientes(ingredientes);

			receitaService.criaReceita(receita, usuario.getId());

			resp.sendRedirect("painelController");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
