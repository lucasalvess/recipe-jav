package br.com.recipe.dto;

import br.com.recipe.model.Ingrediente;
import br.com.recipe.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaDTO {
    private int id;
    private String nome;
    private String descricao;
    private String Categoria;
    private String passos;
    private String tempo;
    private List<Ingrediente> ingredientes;
}
