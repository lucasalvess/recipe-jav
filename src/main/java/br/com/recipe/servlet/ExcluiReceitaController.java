package br.com.recipe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.model.Receita;

public class ExcluiReceitaController extends HttpServlet{

	private ReceitaDAO receitaDAO;

	public ExcluiReceitaController(ReceitaDAO receitaDAO) {
		this.receitaDAO = receitaDAO;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Receita receita =  new Receita();
		receita.setId(Integer.parseInt(req.getParameter("id")));
		
		try {
			receitaDAO.deleta(receita);
			resp.sendRedirect("painelController");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
