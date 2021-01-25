package br.com.recipe.service;

import br.com.recipe.dao.*;
import br.com.recipe.model.Receita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class ReceitaServiceTest {

    private ReceitaDaoStub receitaDaoStub;
    private IngredienteDaoStub ingredienteDaoStub;
    private ReceitaService receitaService;
    private ConexaoStub conexaoStub;

    public ReceitaServiceTest() {
        conexaoStub = new ConexaoStub();
    }

    @BeforeEach
    public void setup() throws SQLException, ClassNotFoundException {
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
