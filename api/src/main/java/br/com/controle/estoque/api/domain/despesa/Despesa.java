package br.com.controle.estoque.api.domain.despesa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Despesa")
@Table(name = "tb_despesas")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private BigDecimal valor;
    @Column(name = "data_despesa")
    private LocalDate dataDespesa;
    private Boolean ativo;

}
