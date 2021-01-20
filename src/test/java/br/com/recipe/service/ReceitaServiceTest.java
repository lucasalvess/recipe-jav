package br.com.recipe.service;

import br.com.recipe.dao.*;
import br.com.recipe.model.Receita;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class ReceitaServiceTest {

    private ReceitaDaoStub receitaDaoStub;
    private IngredienteDaoStub ingredienteDaoStub;
    private ReceitaService receitaService;

    public ReceitaServiceTest() throws SQLException, ClassNotFoundException {
        ConexaoStub conexaoStub = new ConexaoStub();
        receitaDaoStub = new ReceitaDaoStub(conexaoStub);
        ingredienteDaoStub = new IngredienteDaoStub(conexaoStub);
        receitaService = new ReceitaService(receitaDaoStub,ingredienteDaoStub);
    }

    @Test
    public void buscaReceitas_emptyList_thenReturnEmptyList(){
        List<Receita> receitas = receitaService.buscaReceitas();
        assert receitas.isEmpty();
    }

}
