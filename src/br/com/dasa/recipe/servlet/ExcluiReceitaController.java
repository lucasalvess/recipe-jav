package br.com.dasa.recipe.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dasa.recipe.dao.ReceitaDAO;
import br.com.dasa.recipe.model.Receita;

public class ExcluiReceitaController extends HttpServlet{

	public ExcluiReceitaController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Receita receita =  new Receita();
		receita.setId(Integer.parseInt(req.getParameter("id")));
		
		try {
			ReceitaDAO receitaDao =  new ReceitaDAO();
			receitaDao.deleta(receita);
			resp.sendRedirect("painelController");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
