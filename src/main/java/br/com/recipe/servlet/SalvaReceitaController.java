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

public class SalvaReceitaController extends HttpServlet{

	private ReceitaDAO receitaDAO;
	private IngredienteDAO ingredientesDAO;

	public SalvaReceitaController(ReceitaDAO receitaDAO, IngredienteDAO ingredientesDAO) {
		this.receitaDAO = receitaDAO;
		this.ingredientesDAO = ingredientesDAO;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Receita receita = new Receita();
		
		receita.setNome(req.getParameter("nome"));
		receita.setDescricao(req.getParameter("descricao"));
		receita.setCategoria(req.getParameter("categoria"));
		receita.setPassos(req.getParameter("preparo"));
		receita.setTempo(req.getParameter("tempo"));

		try {
			//Grava receitas
			Usuario usuario = new Usuario();
			HttpSession session = req.getSession();
			usuario = (Usuario) session.getAttribute("usuario");
			receitaDAO.salva(receita, usuario);
			
			//Grava ingredientes
			List<Ingrediente> ingredientes = new ArrayList<>();
			System.out.println(req.getParameter("ingredientes"));
			resp.sendRedirect("painelController");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
