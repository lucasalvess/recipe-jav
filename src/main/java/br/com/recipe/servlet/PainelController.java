package br.com.recipe.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;

public class PainelController extends HttpServlet {

	private ReceitaDAO receitaDAO;

	public PainelController(ReceitaDAO receitaDAO) {
		this.receitaDAO = receitaDAO;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("receitas", receitaDAO.lista());
			req.getRequestDispatcher("painel.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
