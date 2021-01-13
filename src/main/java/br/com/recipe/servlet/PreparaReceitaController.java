package br.com.recipe.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.model.Ingrediente;

public class PreparaReceitaController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Ingrediente> ingredientes = new IngredienteDAO().lista();
			req.setAttribute("ingredientes", ingredientes);
			
			req.getRequestDispatcher("prepara-receita.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}	
	}
}
