package br.com.recipe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.model.Receita;

public class AlteraReceitaController extends HttpServlet {

	private ReceitaDAO receitaDAO;

	public AlteraReceitaController(ReceitaDAO receitaDAO) {
		this.receitaDAO = receitaDAO;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
				
		req.setAttribute("receita", receitaDAO.busca(req.getParameter("id")));
		req.getRequestDispatcher("requenta-receita.jsp").forward(req, resp);
		
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Receita receita = new Receita();
			receita.setId(Integer.parseInt(req.getParameter("id")));
			receita.setNome(req.getParameter("nome"));
			receita.setCategoria(req.getParameter("categoria"));
			receita.setDescricao(req.getParameter("descricao"));
			receita.setPassos(req.getParameter("preparo"));
			receita.setTempo(req.getParameter("tempo"));
			
			receitaDAO.atualiza(receita);
			resp.sendRedirect("painelController");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
