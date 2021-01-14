package br.com.recipe.mocks.database;

import br.com.recipe.model.Ingrediente;

public class IngredienteRow {

    private int id;
    private String nome;
    private Integer receitaId;

    public Ingrediente converteIngrediente(){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(this.id);
        ingrediente.setNome(this.nome);
        return ingrediente;
    }

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

    public Integer getReceitaId() {
        return receitaId;
    }
    public void setReceitaId(Integer receitaId) {
        this.receitaId = receitaId;
    }
}
