package br.edu.ifpe.oxefood.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
public abstract class EntidadeNegocio {

    private Long id;

    private Boolean habilitado;
    
}
