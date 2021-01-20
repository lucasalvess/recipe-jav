package br.com.recipe.dao;

import br.com.recipe.config.Conexao;

import java.sql.Connection;

public class ConexaoStub extends Conexao {

    public Connection conecta() {
        return null;
    }
}
