package br.com.recipe.service;

import br.com.recipe.dao.ConexaoStub;
import br.com.recipe.dao.IngredienteDaoStub;
import br.com.recipe.dao.ReceitaDAO;
import br.com.recipe.dao.ReceitaDaoStub;
import br.com.recipe.model.Receita;
import br.com.recipe.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.List;

public class ReceitaServiceTest {

    private ReceitaDaoStub receitaDaoStub;
    private IngredienteDaoStub ingredienteDaoStub;
    private ReceitaService receitaService;
    private final ConexaoStub conexaoStub;

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

    @Test
    public void criaReceita_ValidReceita_thenCallSave() throws SQLException {
        Usuario usuario = new Usuario();
        Receita receita = new Receita();

        receitaService.criaReceita(receita,usuario);

        Mockito.spy(receitaDaoStub).salva(receita,usuario);
    }

}
