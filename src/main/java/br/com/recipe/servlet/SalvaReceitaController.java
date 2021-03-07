package br.com.recipe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.model.Ingrediente;
import br.com.recipe.model.Receita;
import br.com.recipe.model.Usuario;
import br.com.recipe.service.ReceitaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalvaReceitaController extends HttpServlet{

	private final ReceitaService receitaService;
	private final IngredienteDAO ingredientesDAO;

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
			receitaService.criaReceita(receita, usuario.getId());
			
			//Grava ingredientes
			List<Ingrediente> ingredientes = new ArrayList<>();
			System.out.println(req.getParameter("ingredientes"));
			resp.sendRedirect("painelController");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
