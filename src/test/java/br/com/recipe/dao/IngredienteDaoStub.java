package br.com.recipe.dao;

import br.com.recipe.config.Conexao;
import br.com.recipe.mocks.database.IngredienteRow;
import br.com.recipe.model.Ingrediente;
import br.com.recipe.model.Receita;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IngredienteDaoStub extends IngredienteDAO{

    private List<IngredienteRow> tabelaIngrediente = new ArrayList<>();

    public IngredienteDaoStub(Conexao conexao) throws ClassNotFoundException, SQLException {
        super(conexao);
    }

    public List<Ingrediente> lista() throws SQLException {
        return tabelaIngrediente.stream()
                .map(IngredienteRow::converteIngrediente)
                .collect(Collectors.toList());
    }

    public List<Ingrediente> lista(Receita receita) throws SQLException {

        return tabelaIngrediente.stream()
                .filter(ingredienteRow -> ingredienteRow.getReceitaId() == receita.getId())
                .map(IngredienteRow::converteIngrediente)
                .collect(Collectors.toList());
    }
}
