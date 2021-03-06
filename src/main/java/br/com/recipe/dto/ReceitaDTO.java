package br.com.recipe.dto;

import br.com.recipe.model.Receita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaDTO {
    private int id;
    private String nome;
    private String descricao;
    private String categoria;
    private String passos;
    private String tempo;
    private List<IngredienteDTO> ingredientes;

    public ReceitaDTO(Receita receita) {
        this.id = receita.getId();
        this.nome = receita.getNome();
        this.categoria = receita.getCategoria();
        this.descricao = receita.getDescricao();
        this.passos = receita.getPassos();
        this.tempo = receita.getTempo();
        this.ingredientes = (receita.getIngredientes() != null)
                ? receita.getIngredientes()
                    .stream()
                    .map(IngredienteDTO::new)
                    .collect(Collectors.toList())
                : null;
    }
}
