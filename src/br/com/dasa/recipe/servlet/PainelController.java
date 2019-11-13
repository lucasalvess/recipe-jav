package br.com.dasa.recipe.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dasa.recipe.dao.ReceitaDAO;

public class PainelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReceitaDAO receitaDAO;
		try {
			receitaDAO = new ReceitaDAO();
			req.setAttribute("receitas", receitaDAO.lista());
			req.getRequestDispatcher("painel.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
