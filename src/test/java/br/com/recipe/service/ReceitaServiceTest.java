package br.com.recipe.service;

import br.com.recipe.dao.ConexaoStub;
import br.com.recipe.dao.IngredienteDaoStub;
import br.com.recipe.dao.ReceitaDaoStub;
import br.com.recipe.dto.ReceitaDTO;
import br.com.recipe.model.Ingrediente;
import br.com.recipe.model.Receita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void buscaReceitas_existentList_thenReturnList() {
        Integer usuarioId = 1;

        Receita receita = new Receita();
        receita.setIngredientes(Collections.singletonList(new Ingrediente()));
        receita.setNome("Pizza");

        receitaDaoStub.salva(receita,usuarioId);

        List<Receita> receitas = receitaService.buscaReceitas();
        assertThat(receitas.get(0)).isEqualToComparingFieldByField(receita);
    }

    @Test
    public void criaReceita_validReceita_thenCallSaveAndReturnReceita()  {
        Integer usuarioId = 1;
        Receita receita = new Receita();

        ReceitaDTO result = receitaService.criaReceita(receita,1);

        assertThat(new ReceitaDTO(receita)).isEqualToComparingFieldByField(result);
        Mockito.spy(receitaDaoStub).salva(receita,1);
    }

}
