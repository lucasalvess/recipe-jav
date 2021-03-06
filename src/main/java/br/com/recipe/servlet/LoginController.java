package br.com.recipe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.recipe.dao.UsuarioDAO;
import br.com.recipe.model.Usuario;


public class LoginController extends HttpServlet{

	private UsuarioDAO usuarioDAO;

	public LoginController(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
				
		try {
			usuario = usuarioDAO.logar(usuario);
			if(usuario.getId()!=0) {	

				//Cria uma sessão com o usuario
                HttpSession session=req.getSession(true);

                session.setAttribute("usuario", usuario);
                //envia para controller do painelç
               resp.sendRedirect("painelController");
               
			}else {
				req.setAttribute("mensagem", "Usuário sem permissão");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				

			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}
