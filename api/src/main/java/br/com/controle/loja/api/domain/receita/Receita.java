package br.com.controle.loja.api.domain.receita;

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

    public Receita(DadosCadastroReceita dadosCadastroReceita) {
        this.descricao = dadosCadastroReceita.descricao();
        this.valor = dadosCadastroReceita.valor();
        this.dataReceita = dadosCadastroReceita.dataReceita();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoReceita dadosAtualizacaoReceita) {
        if(dadosAtualizacaoReceita.descricao() != null) {
            this.descricao = dadosAtualizacaoReceita.descricao();
        }
        if(dadosAtualizacaoReceita.valor() != null) {
            this.valor = dadosAtualizacaoReceita.valor();
        }
        if(dadosAtualizacaoReceita.dataReceita() != null) {
            this.dataReceita = dadosAtualizacaoReceita.dataReceita();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
