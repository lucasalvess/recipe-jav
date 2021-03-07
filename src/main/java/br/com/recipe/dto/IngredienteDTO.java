package br.com.recipe.dto;

import br.com.recipe.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IngredienteDTO {

    private Integer id;
    private String nome;

    public IngredienteDTO(Ingrediente ingrediente){
        this.id = ingrediente.getId();
        this.nome = ingrediente.getNome();
    }
}
