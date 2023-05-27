package br.com.controle.loja.api.domain.produto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Produto")
@Table(name = "tb_produtos")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    private Boolean ativo;


    public Produto(DadosCadastroProduto dadosCadastroProduto) {
        this.ativo = true;
        this.nome = dadosCadastroProduto.nome();
        this.codigo = dadosCadastroProduto.codigo();
        this.descricao = dadosCadastroProduto.descricao();
        this.valorUnitario = dadosCadastroProduto.valorUnitario();
    }

    public void atualizarProduto(DadosAtualizacaoProduto dadosAtualizacaoProduto) {
        if(dadosAtualizacaoProduto.nome() != null) {
            this.nome = dadosAtualizacaoProduto.nome();
        }
        if(dadosAtualizacaoProduto.codigo() != null) {
            this.codigo = dadosAtualizacaoProduto.codigo();
        }
        if(dadosAtualizacaoProduto.descricao() != null) {
            this.descricao = dadosAtualizacaoProduto.descricao();
        }
        if(dadosAtualizacaoProduto.valorUnitario() != null) {
            this.valorUnitario = dadosAtualizacaoProduto.valorUnitario();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
