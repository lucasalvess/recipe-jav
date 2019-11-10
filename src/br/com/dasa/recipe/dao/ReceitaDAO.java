package br.com.dasa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.dasa.recipe.config.Conexao;
import br.com.dasa.recipe.model.Receita;

public class ReceitaDAO {

	private Connection con;

	public ReceitaDAO() throws SQLException {
		this.con = Conexao.conecta();
	}
		
		// INSERE RECEITA--------------------------------------------------------------------------------------
		public void salva(Receita receita) throws SQLException {
			String sql = "insert into produto(nome,descricao,categoria,tempo,passos) values(?,?,?,?,?)";
			try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, receita.getNome());
				stmt.setString(2, receita.getDescricao());
				stmt.setString(3, receita.getCategoria());
				stmt.setString(4, receita.getPassos());
				stmt.setString(5, receita.getTempo());
				stmt.execute();

				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {// se tiver o proximo valor pra ver
						int id = rs.getInt("id");
						receita.setId(id);
					}

				}
			}finally {
				con.close();
			}
		}

		// LISTA RECEITAS----------------------------------------------------------------------------------------
		public List<Receita> lista() {

			try {

				Statement stmt = con.createStatement();// Statement prepara a query
				List<Receita> listaDeReceitas = new ArrayList<Receita>();// Lista que vai ser retornada com os produtos

				if (stmt.execute("select * from receitas")) {
					ResultSet rs = stmt.getResultSet();

					while (rs.next()) { // monta lista de produtos
						Receita r = new Receita();
						r.setId(rs.getInt("id"));
						r.setNome(rs.getString("nome"));
						r.setDescricao(rs.getString("descricao"));
						r.setCategoria(rs.getString("categoria"));
						r.setPassos(rs.getString("passos"));
						r.setTempo(rs.getString("tempo"));
						listaDeReceitas.add(r);
					}
				}

				return listaDeReceitas;
			} catch (SQLException e) {
				System.out.println(e);
			}
			return null;
		}

		// DELETA RECEITA--------------------------------------------------------------------------------------------
		public boolean deleta(Receita receita) {
			try {
				String sql = "delete from receitas where id= ?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, receita.getId());
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

		// ATUALIZA RECEITA--------------------------------------------------------------------------------------------

		public boolean atualiza(Receita receita) throws SQLException {
			
			try {
				String sql = "UPDATE receitas set nome=?,descricao=?,categoria=?,passos=?,tempo=? WHERE id=?";
				PreparedStatement smtp = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				smtp.setString(1, receita.getNome());
				smtp.setString(2, receita.getDescricao());
				smtp.setString(3, receita.getCategoria());
				smtp.setString(4, receita.getPassos());
				smtp.setString(5, receita.getTempo());
				
				smtp.setInt(6, receita.getId());
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
		
		//Busca receita by id ------------------------------------------------------------------------------------------
		
		public Receita busca(Receita receita) throws SQLException {
			try {
				String sql = "select * from receitas where id=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, receita.getId());
				
				if (stmt.execute()) {
					ResultSet rs = stmt.getResultSet();
					
					if (rs.next()) { // monta receita
						receita.setNome(rs.getString("nome"));
						receita.setDescricao(rs.getString("descricao"));
						receita.setCategoria(rs.getString("categoria"));
						receita.setPassos(rs.getString("passos"));
						receita.setTempo(rs.getString("tempo"));
					}	
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				con.close();			
				return receita;
			}
			
		}
	}

