package br.com.dasa.recipe.service;

import java.util.ArrayList;
import java.util.List;

import br.com.dasa.recipe.dao.ReceitaDAO;
import br.com.dasa.recipe.model.Receita;

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

}
