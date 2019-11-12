package br.com.dasa.recipe.model;

import java.util.List;

public class Receita {
	
	private int id;
	private String nome;
	private String descricao;
	private String Categoria;
	private String passos;
	private String tempo;
	private List<Ingrediente> ingredientes;
	
	public int getId() {
		return id;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
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
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
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

	
}
