package br.com.controle.estoque.api.domain.receita;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Receita")
@Table(name = "tb_receitas")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private BigDecimal valor;
    @Column(name = "data_receita")
    private LocalDate dataReceita;
    private Boolean ativo;

}