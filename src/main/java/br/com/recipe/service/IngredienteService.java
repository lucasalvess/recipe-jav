package br.com.recipe.service;

public class IngredienteService {

	public IngredienteService() {
	}

	public String comparaCategoria(String catSelect, String catReceita) {
		if(catSelect.equals(catReceita)) {
			return "selected";

		}else {
			return "";
		}
				
	}
}
