package br.com.recipe.model;

public class Ingrediente {
	
	private Integer id;
	private String nome;

	public Ingrediente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Ingrediente() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
