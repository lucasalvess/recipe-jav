package br.com.dasa.recipe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dasa.recipe.dao.IngredienteDAO;
import br.com.dasa.recipe.dao.ReceitaDAO;
import br.com.dasa.recipe.model.Receita;
import br.com.dasa.recipe.service.ReceitaService;

public class AcessaReceitaController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			acessaReceita(req.getParameter("d"));			
			req.setAttribute("receita", receita);
			req.setAttribute("ingredientes", ingredienteDAO.lista(receita));
			
			req.getRequestDispatcher("receita.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}	
}
