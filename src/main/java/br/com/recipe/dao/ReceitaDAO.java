package br.com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.recipe.config.Conexao;
import br.com.recipe.dto.ReceitaDTO;
import br.com.recipe.model.Receita;
import br.com.recipe.model.Usuario;

import javax.management.RuntimeMBeanException;

public class ReceitaDAO {

    private Connection con;

    public ReceitaDAO(Conexao conexao) throws SQLException, ClassNotFoundException {
        this.con = conexao.conecta();
    }

    // INSERE RECEITA--------------------------------------------------------------------------------------
    public Receita salva(Receita receita, Integer usuarioId) {
        int receitaCriada;
        final String sql = "insert into receitas(nome,descricao,categoria,tempo,passos,usuario_id) values(?,?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, receita.getNome());
            stmt.setString(2, receita.getDescricao());
            stmt.setString(3, receita.getCategoria());
            stmt.setString(5, receita.getPassos());
            stmt.setString(4, receita.getTempo());
            stmt.setInt(6, usuarioId);
            stmt.execute();

            receitaCriada = stmt.getGeneratedKeys().findColumn("id");

        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return busca(Integer.toString(receitaCriada));
    }

    // LISTA RECEITAS----------------------------------------------------------------------------------------
    public List<Receita> lista() {

        final String sql = "select * from receitas";
        List<Receita> listaDeReceitas = new ArrayList<Receita>();

        try (Statement stmt = con.createStatement()){

            if (stmt.execute(sql)) {
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) { // monta lista de produtos
                    Receita r = new Receita();
                    r.setId(rs.getInt("id"));
                    r.setNome(rs.getString("nome"));
                    r.setDescricao(rs.getString("descricao"));
                    r.setCategoria(rs.getString("categoria"));
                    r.setPassos(rs.getString("passos"));
                    r.setTempo(rs.getString("tempo"));
                    listaDeReceitas.add(r);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return listaDeReceitas;
    }

    // DELETA RECEITA--------------------------------------------------------------------------------------------
    public boolean deleta(Receita receita) throws SQLException {
        try {
            final String sql = "delete from receitas where id= ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, receita.getId());
            statement.execute();

            int count = statement.getUpdateCount();// pega linhas atualizadas

            System.out.println(count + " linhas atualizadas!");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            con.close();
        }
        return false;
    }

    // ATUALIZA RECEITA--------------------------------------------------------------------------------------------

    public void atualiza(Receita receita) throws SQLException {

        try {
            final String sql = "UPDATE receitas set nome=?,descricao=?,categoria=?,passos=?,tempo=? WHERE id=?";
            PreparedStatement smtp = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            smtp.setString(1, receita.getNome());
            smtp.setString(2, receita.getDescricao());
            smtp.setString(3, receita.getCategoria());
            smtp.setString(4, receita.getPassos());
            smtp.setString(5, receita.getTempo());

            smtp.setInt(6, receita.getId());
            if (smtp.execute()) {
                System.out.println("Atualizou a linha: ");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            con.close();
        }

    }

    //Busca receita by id ------------------------------------------------------------------------------------------
    public Receita busca(String id) {
        final String sql = "select * from receitas where id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(id));

            Receita receita = new Receita();

            if (stmt.execute()) {
                ResultSet rs = stmt.getResultSet();

                if (rs.next()) { // monta receita
                    receita.setId(rs.getInt("id"));
                    receita.setNome(rs.getString("nome"));
                    receita.setDescricao(rs.getString("descricao"));
                    receita.setCategoria(rs.getString("categoria"));
                    receita.setPassos(rs.getString("passos"));
                    receita.setTempo(rs.getString("tempo"));
                }
            }
            return receita;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

