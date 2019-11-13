package br.com.dasa.recipe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dasa.recipe.dao.IngredienteDAO;
import br.com.dasa.recipe.dao.ReceitaDAO;
import br.com.dasa.recipe.model.Receita;

public class AcessaReceitaController extends HttpServlet {

	public AcessaReceitaController() {

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			ReceitaDAO receitaDAO = new ReceitaDAO();
			IngredienteDAO ingredienteDAO =  new IngredienteDAO();
			
			Receita receita = receitaDAO.busca(req.getParameter("r"));
			
			req.setAttribute("receita", receita);
			req.setAttribute("ingredientes", ingredienteDAO.lista(receita));
			
			req.getRequestDispatcher("receita.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}	

}
