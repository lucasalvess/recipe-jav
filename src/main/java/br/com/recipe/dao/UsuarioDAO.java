package br.com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.recipe.config.Conexao;
import br.com.recipe.model.Usuario;


public class UsuarioDAO {

	private Connection con;

	public UsuarioDAO() throws SQLException, ClassNotFoundException {
		this.con = Conexao.conecta();
	}
		
		// INSERE Usuario--------------------------------------------------------------------------------------
		public void salva(Usuario usuario) throws SQLException {
			final String sql = "insert into usuarios(nome,email,senha) values(?,?,?)";
			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setString(3, usuario.getSenha());
				stmt.execute();

				}finally {
				con.close();
			}
		}


		// DELETA USUARIO--------------------------------------------------------------------------------------------
		public boolean deleta(Usuario usuario) {
			try {
				final String sql = "delete from usuarios where id= ?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, usuario.getId());
				statement.execute();

				int count = statement.getUpdateCount();// pega linhas atualizadas

				System.out.println(count + " linhas atualizadas!");
				return true;
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

		// ATUALIZA USUARIO--------------------------------------------------------------------------------------------

		public boolean atualiza(Usuario usuario) throws SQLException {
			
			try {
				final String sql = "UPDATE usuarios set nome=?,email=?,senha=? WHERE id=?";
				PreparedStatement smtp = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				smtp.setString(1, usuario.getNome());
				smtp.setString(2, usuario.getEmail());
				smtp.setString(3, usuario.getSenha());				
				smtp.setInt(4, usuario.getId());
				if (smtp.execute()) {
					System.out.println("Atualizou a linha: ");
				}
				return true;
			}catch(Exception e) {
				return false;
			}finally {
				con.close();
			}
			
		}
		
		//Find Usuario by email and passwor ------------------------------------------------------------------------------------------
		
		public Usuario logar(Usuario usuario) throws SQLException {
			try {
				final String sql = "select * from usuarios where email=? and senha=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, usuario.getEmail());
				stmt.setString(2, usuario.getSenha());

				
				if (stmt.execute()) {
					ResultSet rs = stmt.getResultSet();
					
					if (rs.next()) { // monta receita
						usuario.setId(rs.getInt("id"));
						usuario.setNome(rs.getString("nome"));
						usuario.setEmail(rs.getString("email"));
					}	
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				con.close();			
				return usuario;
			}
			
		}

}
