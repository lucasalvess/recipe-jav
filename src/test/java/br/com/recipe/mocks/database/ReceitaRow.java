package br.com.recipe.mocks.database;

import br.com.recipe.model.Ingrediente;
import br.com.recipe.model.Receita;

import java.util.List;

public class ReceitaRow {

    private int id;
    private String nome;
    private String descricao;
    private String categoria;
    private String passos;
    private String tempo;
    private List<Ingrediente> ingredientes;
    private Integer usuarioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPassos() {
        return passos;
    }

    public void setPassos(String passos) {
        this.passos = passos;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public ReceitaRow(int usuarioId, Receita receita) {
        this.id = receita.getId();
        this.nome = receita.getNome();
        this.descricao = receita.getDescricao();
        categoria = receita.getCategoria();
        this.passos = receita.getPassos();
        this.tempo = receita.getTempo();
        this.ingredientes = receita.getIngredientes();
        this.usuarioId = usuarioId;
    }

    public Receita converteReceita(){
        Receita receita = new Receita();
        receita.setCategoria(this.getCategoria());
        receita.setDescricao(this.getDescricao());
        receita.setId(this.getId());
        receita.setNome(this.getNome());
        receita.setPassos(this.getPassos());
        receita.setTempo(this.getTempo());
        receita.setIngredientes(this.getIngredientes());
        return receita;
    }
}
