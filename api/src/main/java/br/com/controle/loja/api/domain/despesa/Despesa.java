package br.com.controle.loja.api.domain.despesa;

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

    public Despesa(DadosCadastroDespesa dadosCadastroDespesa) {
        this.descricao = dadosCadastroDespesa.descricao();
        this.valor = dadosCadastroDespesa.valor();
        this.dataDespesa = dadosCadastroDespesa.dataDespesa();
        this.ativo = true;
    }

    public void atualizarDespesa(DadosAtualizacaoDespesa dadosAtualizacaoDespesa) {
        if(dadosAtualizacaoDespesa.descricao() != null) {
            this.descricao = dadosAtualizacaoDespesa.descricao();
        }
        if(dadosAtualizacaoDespesa.valor() != null) {
            this.valor = dadosAtualizacaoDespesa.valor();
        }
        if(dadosAtualizacaoDespesa.dataDespesa() != null) {
            this.dataDespesa = dadosAtualizacaoDespesa.dataDespesa();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
