package br.com.recipe.servlet;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.model.Receita;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AcessaReceitaController extends HttpServlet {


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
