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

    @Override
    public Receita salva(Receita receita,  Integer usuario) {
        tabelaReceita.add(new ReceitaRow(usuario, receita));
        return receita;
    }

    @Override
    public List<Receita> lista() {
        return tabelaReceita.stream()
                .map(ReceitaRow::converteReceita)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleta(Receita receita) {
        return tabelaReceita.remove(receita);
    }

    @Override
    public void atualiza(Receita receita) {
        Optional<ReceitaRow> row = tabelaReceita.stream()
                .filter(linhaAtual -> linhaAtual.getId() == receita.getId())
                .findFirst();

        row.ifPresent(
                receitaRow -> {
                    int index = tabelaReceita.indexOf(receitaRow);
                    ReceitaRow novaLinha = new ReceitaRow(receitaRow.getUsuarioId(), receita);
                    tabelaReceita.set(index, novaLinha);
                });
    }

    @Override
    public Receita busca(String id) {
        Optional<ReceitaRow> row = tabelaReceita.stream()
                .filter(linhaAtual -> linhaAtual.getId() == Integer.parseInt(id))
                .findFirst();

        return row.map(ReceitaRow::converteReceita).orElseGet(null);
    }
}
