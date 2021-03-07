package br.com.recipe.service;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.dto.ReceitaDTO;
import br.com.recipe.model.Receita;
import br.com.recipe.model.Usuario;

import java.util.List;

public class ReceitaService {

    private ReceitaDAO receitaDAO;
    private IngredienteDAO ingredienteDAO;

    public ReceitaService(ReceitaDAO receitaDAO, IngredienteDAO ingredienteDAO) {
        this.receitaDAO = receitaDAO;
        this.ingredienteDAO = ingredienteDAO;
    }

    public ReceitaDTO buscaReceita(){

    }

    public List<Receita> buscaReceitas() {
        try {
            return receitaDAO.lista();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void criaReceita(Receita receita, Usuario usuario) {
        try {
            receitaDAO.salva(receita,usuario);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
