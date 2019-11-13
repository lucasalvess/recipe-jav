package br.com.dasa.recipe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

	public Logout() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		HttpSession session = req.getSession();
		session.removeAttribute("usuario.logado");
		session.setAttribute("mensagem", "<script>Swal.fire('Usuario deslogado com sucesso')</script>");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
