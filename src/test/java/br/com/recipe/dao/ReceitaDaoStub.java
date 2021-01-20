package br.com.recipe.dao;

import br.com.recipe.config.Conexao;
import br.com.recipe.mocks.database.ReceitaRow;
import br.com.recipe.model.Receita;
import br.com.recipe.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReceitaDaoStub extends ReceitaDAO {

    public ReceitaDaoStub() throws SQLException, ClassNotFoundException {
        super(null);
    }

    private List<ReceitaRow> tabelaReceita = new ArrayList<>();

    public ReceitaDaoStub(Conexao conexao) throws SQLException, ClassNotFoundException {
        super(conexao);
    }

    public void salva(Receita receita, Usuario usuario) throws SQLException {
        tabelaReceita.add(new ReceitaRow(usuario.getId(), receita));
    }

    public List<Receita> lista() throws SQLException {
        return tabelaReceita.stream()
                .map(ReceitaRow::converteReceita)
                .collect(Collectors.toList());
    }

    public boolean deleta(Receita receita) throws SQLException {
        return tabelaReceita.remove(receita);
    }

    public void atualiza(Receita receita) throws SQLException {
        Optional<ReceitaRow> row = tabelaReceita.stream()
                .filter(linhaAtual -> linhaAtual.getId() == receita.getId())
                .findFirst();

        row.ifPresent(
                receitaRow -> {
                    int index = tabelaReceita.indexOf(receitaRow);
                    ReceitaRow novaLinha = new ReceitaRow(receitaRow.getUsuarioId(),receita);
                    tabelaReceita.set(index,novaLinha);
                });
    }

    public Receita busca(String id) throws SQLException {
        Optional<ReceitaRow> row = tabelaReceita.stream()
                .filter(linhaAtual -> linhaAtual.getId() == Integer.parseInt(id))
                .findFirst();

        return row.map(ReceitaRow::converteReceita).orElseGet(null);
    }
}
