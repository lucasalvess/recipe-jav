package br.com.recipe.service;

import java.util.ArrayList;
import java.util.List;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.model.Receita;

public class ReceitaService {

	public List<Receita> buscaReceitas() {
		try {
			ReceitaDAO rdao = new ReceitaDAO();
			List<Receita> receitas = new ArrayList<Receita>();
			receitas = rdao.lista();
			return receitas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public boolean CriaReceita(String receitaId) {
		try{
			ReceitaDAO receitaDAO = new ReceitaDAO();
			IngredienteDAO ingredienteDAO =  new IngredienteDAO();
			
			Receita receita = receitaDAO.busca(receitaId);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
