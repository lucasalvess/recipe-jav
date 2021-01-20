package br.com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.recipe.config.Conexao;
import br.com.recipe.model.Ingrediente;
import br.com.recipe.model.Receita;

public class IngredienteDAO {

	private Connection con;
	private Conexao conexao;

	public IngredienteDAO(Conexao conexao) throws ClassNotFoundException, SQLException {
		this.con = conexao.conecta();
	}

	// LISTA INGREDIENTES----------------------------------------------------------------------------------------
	public List<Ingrediente> lista() throws SQLException {

		try {

			Statement stmt = con.createStatement();// Statement prepara a query
			List<Ingrediente> listaDeIngredientes = new ArrayList<Ingrediente>();// Lista que vai ser retornada com os
			final String sql = "select * from ingredientes";																		// produtos

			if (stmt.execute(sql)) {
				ResultSet rs = stmt.getResultSet();

				while (rs.next()) { // monta lista de ingredientes

					Ingrediente ingrediente = new Ingrediente();
					ingrediente.setId(rs.getInt("id"));
					ingrediente.setNome(rs.getString("nome"));
					listaDeIngredientes.add(ingrediente);
				}
			}

			return listaDeIngredientes;
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			con.close();
		}
		return null;
	}
	
	//INGREDIENTES DA RECEITA----------------------------------------------------------
	public List<Ingrediente> lista(Receita receita) throws SQLException {

		try {
			
			final String sql = "SELECT ingredientes.id , ingredientes.nome FROM `ingredientes`,`composicao` WHERE ingredientes.id = composicao.ingrediente_id and composicao.receita_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);// Statement prepara a query
			
			stmt.setInt(1, receita.getId());
			
			// Lista que vai ser retornada com os ingredientes
			
			List<Ingrediente> listaDeIngredientes = new ArrayList<Ingrediente>();															
						
			if (stmt.execute()) {
				ResultSet rs = stmt.getResultSet();

				while (rs.next()) { // monta lista de ingredientes

					Ingrediente ingrediente = new Ingrediente();
					ingrediente.setId(rs.getInt("id"));
					ingrediente.setNome(rs.getString("nome"));
					listaDeIngredientes.add(ingrediente);
				}
			}

			return listaDeIngredientes;
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			con.close();
		}
		return null;
	}

}