package br.com.recipe.dao;

import br.com.recipe.config.Conexao;
import br.com.recipe.model.Ingrediente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {

    private final Connection con;

    public IngredienteDAO(Conexao conexao) throws ClassNotFoundException, SQLException {
        this.con = conexao.conecta();
    }

    // LISTA INGREDIENTES----------------------------------------------------------------------------------------
    public List<Ingrediente> buscaIngredientesPorIdDaReceita() throws SQLException {

        final String sql = "select * from ingredientes";

        try (Statement stmt = con.createStatement()) {

            List<Ingrediente> listaDeIngredientes = new ArrayList<>();

            if (stmt.execute(sql)) {
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {

                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setId(rs.getInt("id"));
                    ingrediente.setNome(rs.getString("nome"));
                    listaDeIngredientes.add(ingrediente);
                }
            }

            return listaDeIngredientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //INGREDIENTES DA RECEITA----------------------------------------------------------
    public List<Ingrediente> buscaIngredientesPorIdDaReceita(Integer receitaId) {

        final String sql = "SELECT ingredientes.id , ingredientes.nome FROM `ingredientes`,`composicao` WHERE ingredientes.id = composicao.ingrediente_id and composicao.receita_id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, receitaId);


            List<Ingrediente> listaDeIngredientes = new ArrayList<>();

            if (stmt.execute()) {
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {

                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setId(rs.getInt("id"));
                    ingrediente.setNome(rs.getString("nome"));
                    listaDeIngredientes.add(ingrediente);
                }
            }

            return listaDeIngredientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
