package br.com.recipe.service;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.model.Receita;

import java.util.ArrayList;
import java.util.List;

public class ReceitaService {

    private ReceitaDAO receitaDAO;
    private IngredienteDAO ingredienteDAO;

    public ReceitaService(ReceitaDAO receitaDAO, IngredienteDAO ingredienteDAO) {
        this.receitaDAO = receitaDAO;
        this.ingredienteDAO = ingredienteDAO;
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
        try {

            Receita receita = receitaDAO.busca(receitaId);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

}
