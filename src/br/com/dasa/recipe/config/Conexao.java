package br.com.dasa.recipe.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Conexao {
	
	public Conexao() throws SQLException {
		this.conecta();
	}
	
	public static Connection conecta() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost:80/controle-receitas","lucas","password");
	}
}
