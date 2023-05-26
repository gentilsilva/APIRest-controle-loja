package br.com.controle.estoque.api.domain.produto;

import lombok.Getter;

import java.math.BigDecimal;

public record ProdutoDTO(
        Long id,
        String nome,
        String codigo,
        BigDecimal valorUnitario
) {
    public ProdutoDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getCodigo(), produto.getValorUnitario());
    }
}
