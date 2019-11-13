package br.com.dasa.recipe.controller;

public class IngredienteController {

	public IngredienteController() {
	}

	public String comparaCategoria(String catSelect, String catReceita) {
		if(catSelect.equals(catReceita)) {
			return "selected";

		}else {
			return "";
		}
				
	}
}
