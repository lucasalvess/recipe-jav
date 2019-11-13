package br.com.dasa.recipe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dasa.recipe.dao.UsuarioDAO;
import br.com.dasa.recipe.model.Usuario;

@WebServlet(urlPatterns = "/cadastra-usuario")
public class CadastroUsuario extends HttpServlet{

	public CadastroUsuario() {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario usuario = new Usuario();
		usuario.setNome(req.getParameter("usuario"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setSenha(req.getParameter("senha"));
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salva(usuario);
			resp.sendRedirect("login");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
