package br.com.recipe.service;

import br.com.recipe.dao.IngredienteDAO;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.dto.ReceitaDTO;
import br.com.recipe.model.Receita;

import java.util.List;

public class ReceitaService {

    private ReceitaDAO receitaDAO;
    private IngredienteDAO ingredienteDAO;

    public ReceitaService(ReceitaDAO receitaDAO, IngredienteDAO ingredienteDAO) {
        this.receitaDAO = receitaDAO;
        this.ingredienteDAO = ingredienteDAO;
    }

    public List<Receita> buscaReceitas() {
        return receitaDAO.lista();
    }
    
    public ReceitaDTO criaReceita(Receita receita, Integer usuarioId) {
        return new ReceitaDTO(receitaDAO.salva(receita,usuarioId));
    }

}
