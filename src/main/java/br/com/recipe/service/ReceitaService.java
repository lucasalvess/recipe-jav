package br.com.recipe.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.model.Receita;

public class ReceitaService {

	private ReceitaDAO receitaDAO;
	private IngredienteDAO ingredienteDAO;

	public ReceitaService() throws SQLException, ClassNotFoundException {
		this.receitaDAO = getReceitaDAO();
		this.ingredienteDAO = getIngredienteDAO();
	}

	public List<Receita> buscaReceitas() {
		try {

			List<Receita> receitas = new ArrayList<Receita>();
			receitas = receitaDAO.lista();
			return receitas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public boolean CriaReceita(String receitaId) {
		try{

			Receita receita = receitaDAO.busca(receitaId);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}

	}

	protected static ReceitaDAO getReceitaDAO() throws SQLException, ClassNotFoundException {
		return new ReceitaDAO();
	}

	protected static IngredienteDAO getIngredienteDAO() throws SQLException, ClassNotFoundException {
		return new IngredienteDAO();
	}

}
