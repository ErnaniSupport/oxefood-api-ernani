package br.edu.ifpe.oxefood.api.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String descricao;
}