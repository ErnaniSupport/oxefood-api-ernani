package br.edu.ifpe.oxefood.api.produto;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CategoriaProduto")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProduto extends EntidadeAuditavel {

    @Column
    private String descricao;

}

