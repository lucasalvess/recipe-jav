package br.com.dasa.recipe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dasa.recipe.dao.UsuarioDAO;
import br.com.dasa.recipe.model.Usuario;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{

	public Login() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		PrintWriter writer = resp.getWriter();
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			if(usuarioDAO.logar(usuario)!=null) {
				writer.println("Logou o usuario"+ usuario.getId());
			}else {
				writer.println("usuario invalido");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}
