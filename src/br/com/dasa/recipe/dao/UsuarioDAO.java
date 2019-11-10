package br.com.dasa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.dasa.recipe.config.Conexao;
import br.com.dasa.recipe.model.Usuario;


public class UsuarioDAO {

	private Connection con;

	public UsuarioDAO() throws SQLException {
		this.con = Conexao.conecta();
	}
		
		// INSERE Usuario--------------------------------------------------------------------------------------
		public void salva(Usuario usuario) throws SQLException {
			String sql = "insert into usuarios(nome,email,senha) values(?,?,?)";
			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setString(3, usuario.getSenha());
				stmt.execute();

				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {// se tiver o proximo valor pra ver
						int id = rs.getInt("id");
						usuario.setId(id);
					}

				}
			}finally {
				con.close();
			}
		}


		// DELETA USUARIO--------------------------------------------------------------------------------------------
		public boolean deleta(Usuario usuario) {
			try {
				String sql = "delete from usuarios where id= ?";
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
				String sql = "UPDATE usuarios set nome=?,email=?,senha=? WHERE id=?";
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
		
		//Busca Usuario by id ------------------------------------------------------------------------------------------
		
		public Usuario busca(Usuario usuario) throws SQLException {
			try {
				String sql = "select * from usuarios where id=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, usuario.getId());
				
				if (stmt.execute()) {
					ResultSet rs = stmt.getResultSet();
					
					if (rs.next()) { // monta receita
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